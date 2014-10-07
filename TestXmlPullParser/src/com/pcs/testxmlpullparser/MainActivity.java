package com.pcs.testxmlpullparser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.client.Response;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pcs.testxmlpullparser.retrofit.test.SimpleXmlConverter;
import com.pcs.testxmlpullparser.retrofit.test.Utils;
import com.pcs.testxmlpullparser.retrofit.test.WeatherService;
import com.sncr.xmlutils.SimpleXmlUtils;

public class MainActivity extends Activity {
    public static final boolean IS_RETROFIT = false;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (IS_RETROFIT) {
            // Calling service using retrofit..
            callRetrofit();
        } else {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    InputStream fetchXML = fetchXML("Vizag");
                    callWeatherApi(fetchXML);
                }
            }).start();
        }

    }

    /**
     * Call weather api.
     */
    public void callWeatherApi(InputStream in) {
        WeatherData data = null;
        try {
            data = getWeatherData(in);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data != null) {
            final String message = "City: " + data.getCity() + "; Country:" + data.getCoutry();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            });
            Log.i("Response From Weather Data object..", message);
        }
    }

    /**
     * Fetch xml.
     * @param city the city
     * @return the input stream
     */
    public InputStream fetchXML(String city) {
        // Source of weather api: http://openweathermap.org/current
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&mode=xml", city);
        try {
            // Creating a connection
            HttpGet g = new HttpGet(url);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse response = httpClient.execute(g);
            return response.getEntity().getContent();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return null;
    }

    /***
     * @param in
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    public WeatherData getWeatherData(InputStream in) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        // Set the input as read it from the a START_DOCUMENT
        parser.setInput(in, null);

        // Start parsing the xml here..
        int event = parser.getEventType();
        String tagName = null;
        String currentTag = null;
        WeatherData data = new WeatherData();
        while (event != XmlPullParser.END_DOCUMENT) {
            tagName = parser.getName();
            switch (event) {
                case XmlPullParser.START_TAG:
                    Log.i("START_TAG", tagName);
                    currentTag = tagName;
                    extractingDataAttrs(parser, currentTag, data);
                    break;
                case XmlPullParser.END_TAG:
                    Log.i("END_TAG", tagName);
                    break;
                case XmlPullParser.TEXT:
                    extractingData(parser, currentTag, data);
                    currentTag = null;
                    Log.v("Text", parser.getText());
                    break;
            }
            event = parser.next();
        }
        if (in != null)
            in.close();
        return data;
    }

    /**
     * Extracting data.
     * @param parser the parser
     * @param currentTag the current tag
     * @param data the data
     */
    private void extractingDataAttrs(XmlPullParser parser, String currentTag, WeatherData data) {
        if ("city".equals(currentTag)) {
            data.setCity(parser.getAttributeValue(null, "name"));
        } else if ("sun".equals(currentTag)) {
            data.setSunSet(parser.getAttributeValue(null, "set"));
            data.setSunRise(parser.getAttributeValue(null, "rise"));
        } else if ("temperature".equals(currentTag)) {
            data.setTemparature(parser.getAttributeValue(null, "value"));
            data.setMinTemp(parser.getAttributeValue(null, "min"));
            data.setMaxTemp(parser.getAttributeValue(null, "max"));
            data.setUnit(parser.getAttributeValue(null, "unit"));
        } else if ("humidity".equals(currentTag)) {
            data.setHumidity(parser.getAttributeValue(null, "value"));
        } else if ("clouds".equals(currentTag)) {
            data.setCloudsName(parser.getAttributeValue(null, "name"));
        } else if ("speed".equals(currentTag)) {
            data.setWindSpeed(parser.getAttributeValue(null, "value"));
        }
    }

    private void extractingData(XmlPullParser parser, String currentTag, WeatherData data) {
        if ("country".equals(currentTag)) {
            data.setCoutry(parser.getText());
            Log.e("Text", parser.getText());
        }
    }

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5";

    /**
     * Call retrofit.
     */
    public void callRetrofit() {
        final RestAdapter mRestAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).setLogLevel(LogLevel.FULL)
                .setConverter(new SimpleXmlConverter(SimpleXmlUtils.getPersister())).build();
        final WeatherService mWeatherService = mRestAdapter.create(WeatherService.class);
        new Thread(new Runnable() {

            @Override
            public void run() {
                Response response = mWeatherService.getWeather("Vizag", "xml");

                try {
                    final String responseStr = Utils.toString(response.getBody().in());
                    callWeatherApi(response.getBody().in());
                    // you can parse this string response later...
                    Log.v("Retrofit Response", "" + responseStr);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, responseStr, Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
