package com.osacky.umbrella.data.api;

import com.google.gson.Gson;
import com.osacky.umbrella.data.api.model.WeatherResult;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.http.Path;
import rx.Observable;

@Singleton
public class MockWeatherService implements WeatherService {
    private final Gson mGson;

    @Inject MockWeatherService(Gson gson) {
        mGson = gson;
    }

    @Override
    public Observable<WeatherResult> getWeather(
            @Path("latitude") double latitude, @Path("longitude") double longitude) {
        return Observable.just(mGson.fromJson(JSON_SEATTLE_FORECAST, WeatherResult.class));
    }

    public static final String JSON_SEATTLE_FORECAST = "{\n" +
            "    \"latitude\": 47.609,\n" +
            "    \"longitude\": -122.333,\n" +
            "    \"timezone\": \"America/Los_Angeles\",\n" +
            "    \"offset\": -7,\n" +
            "    \"currently\": {\n" +
            "        \"time\": 1411856173,\n" +
            "        \"summary\": \"Partly Cloudy\",\n" +
            "        \"icon\": \"partly-cloudy-day\",\n" +
            "        \"nearestStormDistance\": 51,\n" +
            "        \"nearestStormBearing\": 158,\n" +
            "        \"precipIntensity\": 0,\n" +
            "        \"precipProbability\": 0,\n" +
            "        \"temperature\": 66.81,\n" +
            "        \"apparentTemperature\": 66.81,\n" +
            "        \"dewPoint\": 55.54,\n" +
            "        \"humidity\": 0.67,\n" +
            "        \"windSpeed\": 7.18,\n" +
            "        \"windBearing\": 350,\n" +
            "        \"visibility\": 10,\n" +
            "        \"cloudCover\": 0.27,\n" +
            "        \"pressure\": 1018.71,\n" +
            "        \"ozone\": 298.09\n" +
            "    },\n" +
            "    \"minutely\": {\n" +
            "        \"summary\": \"Partly cloudy for the hour.\",\n" +
            "        \"icon\": \"partly-cloudy-day\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411856160,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856220,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856280,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856340,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856400,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856460,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856520,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856580,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856640,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856700,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856760,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856820,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856880,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411856940,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857000,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857060,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857120,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857180,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857240,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857300,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857360,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857420,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857480,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857540,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857600,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857660,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857720,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857780,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857840,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857900,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411857960,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858020,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858080,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858140,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858200,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858260,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858320,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858380,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858440,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858500,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858560,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858620,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858680,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858740,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858800,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858860,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858920,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858980,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859040,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859100,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859160,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859220,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859280,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859340,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859400,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859460,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859520,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859580,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859640,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859700,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411859760,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"hourly\": {\n" +
            "        \"summary\": \"Rain starting this evening, continuing until tomorrow morning.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411855200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 66.72,\n" +
            "                \"apparentTemperature\": 66.72,\n" +
            "                \"dewPoint\": 55.85,\n" +
            "                \"humidity\": 0.68,\n" +
            "                \"windSpeed\": 6.82,\n" +
            "                \"windBearing\": 347,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.3,\n" +
            "                \"pressure\": 1018.75,\n" +
            "                \"ozone\": 298.49\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411858800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 67.04,\n" +
            "                \"apparentTemperature\": 67.04,\n" +
            "                \"dewPoint\": 54.68,\n" +
            "                \"humidity\": 0.65,\n" +
            "                \"windSpeed\": 8.24,\n" +
            "                \"windBearing\": 358,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.18,\n" +
            "                \"pressure\": 1018.61,\n" +
            "                \"ozone\": 297.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411862400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 66.51,\n" +
            "                \"apparentTemperature\": 66.51,\n" +
            "                \"dewPoint\": 54.03,\n" +
            "                \"humidity\": 0.64,\n" +
            "                \"windSpeed\": 7.8,\n" +
            "                \"windBearing\": 0,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.16,\n" +
            "                \"pressure\": 1018.52,\n" +
            "                \"ozone\": 295.75\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411866000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 64.97,\n" +
            "                \"apparentTemperature\": 64.97,\n" +
            "                \"dewPoint\": 53.74,\n" +
            "                \"humidity\": 0.67,\n" +
            "                \"windSpeed\": 7.37,\n" +
            "                \"windBearing\": 2,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.25,\n" +
            "                \"pressure\": 1018.46,\n" +
            "                \"ozone\": 294.93\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411869600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 62.55,\n" +
            "                \"apparentTemperature\": 62.55,\n" +
            "                \"dewPoint\": 53.78,\n" +
            "                \"humidity\": 0.73,\n" +
            "                \"windSpeed\": 5.93,\n" +
            "                \"windBearing\": 7,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.3,\n" +
            "                \"pressure\": 1018.47,\n" +
            "                \"ozone\": 294.33\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411873200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 60.67,\n" +
            "                \"apparentTemperature\": 60.67,\n" +
            "                \"dewPoint\": 53.69,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 4.94,\n" +
            "                \"windBearing\": 11,\n" +
            "                \"visibility\": 9.77,\n" +
            "                \"cloudCover\": 0.34,\n" +
            "                \"pressure\": 1018.55,\n" +
            "                \"ozone\": 293.68\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411876800,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 58.35,\n" +
            "                \"apparentTemperature\": 58.35,\n" +
            "                \"dewPoint\": 52.56,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 4.49,\n" +
            "                \"windBearing\": 15,\n" +
            "                \"visibility\": 9.27,\n" +
            "                \"cloudCover\": 0.32,\n" +
            "                \"pressure\": 1018.78,\n" +
            "                \"ozone\": 292.9\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411880400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 57.45,\n" +
            "                \"apparentTemperature\": 57.45,\n" +
            "                \"dewPoint\": 52.13,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 4.3,\n" +
            "                \"windBearing\": 16,\n" +
            "                \"visibility\": 9.28,\n" +
            "                \"cloudCover\": 0.27,\n" +
            "                \"pressure\": 1019.07,\n" +
            "                \"ozone\": 292.07\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411884000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.75,\n" +
            "                \"apparentTemperature\": 56.75,\n" +
            "                \"dewPoint\": 51.88,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 4.05,\n" +
            "                \"windBearing\": 18,\n" +
            "                \"visibility\": 9.3,\n" +
            "                \"cloudCover\": 0.27,\n" +
            "                \"pressure\": 1019.23,\n" +
            "                \"ozone\": 291.17\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411887600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.35,\n" +
            "                \"apparentTemperature\": 56.35,\n" +
            "                \"dewPoint\": 51.78,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 4.03,\n" +
            "                \"windBearing\": 20,\n" +
            "                \"visibility\": 9.34,\n" +
            "                \"cloudCover\": 0.28,\n" +
            "                \"pressure\": 1019.17,\n" +
            "                \"ozone\": 290.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411891200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.22,\n" +
            "                \"apparentTemperature\": 56.22,\n" +
            "                \"dewPoint\": 51.88,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 4.16,\n" +
            "                \"windBearing\": 22,\n" +
            "                \"visibility\": 9.39,\n" +
            "                \"cloudCover\": 0.33,\n" +
            "                \"pressure\": 1018.98,\n" +
            "                \"ozone\": 288.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411894800,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.55,\n" +
            "                \"apparentTemperature\": 55.55,\n" +
            "                \"dewPoint\": 51.47,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.03,\n" +
            "                \"windBearing\": 21,\n" +
            "                \"visibility\": 9.47,\n" +
            "                \"cloudCover\": 0.39,\n" +
            "                \"pressure\": 1018.74,\n" +
            "                \"ozone\": 288.02\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411898400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.16,\n" +
            "                \"apparentTemperature\": 55.16,\n" +
            "                \"dewPoint\": 51.01,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.66,\n" +
            "                \"windBearing\": 18,\n" +
            "                \"visibility\": 9.47,\n" +
            "                \"cloudCover\": 0.3,\n" +
            "                \"pressure\": 1018.42,\n" +
            "                \"ozone\": 287.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411902000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.54,\n" +
            "                \"apparentTemperature\": 54.54,\n" +
            "                \"dewPoint\": 50.45,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.62,\n" +
            "                \"windBearing\": 17,\n" +
            "                \"visibility\": 9.51,\n" +
            "                \"cloudCover\": 0.34,\n" +
            "                \"pressure\": 1018.06,\n" +
            "                \"ozone\": 286.7\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411905600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.05,\n" +
            "                \"apparentTemperature\": 54.05,\n" +
            "                \"dewPoint\": 49.91,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.1,\n" +
            "                \"windBearing\": 16,\n" +
            "                \"visibility\": 9.56,\n" +
            "                \"cloudCover\": 0.3,\n" +
            "                \"pressure\": 1017.73,\n" +
            "                \"ozone\": 286.2\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411909200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 53.71,\n" +
            "                \"apparentTemperature\": 53.71,\n" +
            "                \"dewPoint\": 49.53,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.06,\n" +
            "                \"windBearing\": 13,\n" +
            "                \"visibility\": 9.59,\n" +
            "                \"cloudCover\": 0.36,\n" +
            "                \"pressure\": 1017.47,\n" +
            "                \"ozone\": 285.71\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411912800,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 53.37,\n" +
            "                \"apparentTemperature\": 53.37,\n" +
            "                \"dewPoint\": 49.24,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 3.76,\n" +
            "                \"windBearing\": 11,\n" +
            "                \"visibility\": 9.59,\n" +
            "                \"cloudCover\": 0.33,\n" +
            "                \"pressure\": 1017.25,\n" +
            "                \"ozone\": 285.31\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411916400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.14,\n" +
            "                \"apparentTemperature\": 54.14,\n" +
            "                \"dewPoint\": 50.07,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 3.88,\n" +
            "                \"windBearing\": 9,\n" +
            "                \"visibility\": 9.76,\n" +
            "                \"cloudCover\": 0.4,\n" +
            "                \"pressure\": 1017.04,\n" +
            "                \"ozone\": 285.07\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411920000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.52,\n" +
            "                \"apparentTemperature\": 56.52,\n" +
            "                \"dewPoint\": 50.92,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 4.04,\n" +
            "                \"windBearing\": 1,\n" +
            "                \"visibility\": 9.87,\n" +
            "                \"cloudCover\": 0.34,\n" +
            "                \"pressure\": 1016.88,\n" +
            "                \"ozone\": 285.08\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411923600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 59.43,\n" +
            "                \"apparentTemperature\": 59.43,\n" +
            "                \"dewPoint\": 51.95,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 4.34,\n" +
            "                \"windBearing\": 354,\n" +
            "                \"visibility\": 9.93,\n" +
            "                \"cloudCover\": 0.26,\n" +
            "                \"pressure\": 1016.72,\n" +
            "                \"ozone\": 285.25\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411927200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 62,\n" +
            "                \"apparentTemperature\": 62,\n" +
            "                \"dewPoint\": 52.37,\n" +
            "                \"humidity\": 0.71,\n" +
            "                \"windSpeed\": 4.67,\n" +
            "                \"windBearing\": 349,\n" +
            "                \"visibility\": 9.97,\n" +
            "                \"cloudCover\": 0.2,\n" +
            "                \"pressure\": 1016.45,\n" +
            "                \"ozone\": 285.48\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411930800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 65.15,\n" +
            "                \"apparentTemperature\": 65.15,\n" +
            "                \"dewPoint\": 53.53,\n" +
            "                \"humidity\": 0.66,\n" +
            "                \"windSpeed\": 5.24,\n" +
            "                \"windBearing\": 346,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.11,\n" +
            "                \"pressure\": 1016.02,\n" +
            "                \"ozone\": 285.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411934400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 67.22,\n" +
            "                \"apparentTemperature\": 67.22,\n" +
            "                \"dewPoint\": 53.63,\n" +
            "                \"humidity\": 0.62,\n" +
            "                \"windSpeed\": 5.44,\n" +
            "                \"windBearing\": 348,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1015.49,\n" +
            "                \"ozone\": 286.26\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411938000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 68.68,\n" +
            "                \"apparentTemperature\": 68.68,\n" +
            "                \"dewPoint\": 53.15,\n" +
            "                \"humidity\": 0.58,\n" +
            "                \"windSpeed\": 5.52,\n" +
            "                \"windBearing\": 348,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1014.95,\n" +
            "                \"ozone\": 286.36\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411941600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 69.88,\n" +
            "                \"apparentTemperature\": 69.88,\n" +
            "                \"dewPoint\": 53.22,\n" +
            "                \"humidity\": 0.55,\n" +
            "                \"windSpeed\": 5.47,\n" +
            "                \"windBearing\": 348,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.06,\n" +
            "                \"pressure\": 1014.4,\n" +
            "                \"ozone\": 286.03\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411945200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 70.15,\n" +
            "                \"apparentTemperature\": 70.15,\n" +
            "                \"dewPoint\": 53.11,\n" +
            "                \"humidity\": 0.55,\n" +
            "                \"windSpeed\": 5.29,\n" +
            "                \"windBearing\": 350,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.03,\n" +
            "                \"pressure\": 1013.88,\n" +
            "                \"ozone\": 285.38\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 69.48,\n" +
            "                \"apparentTemperature\": 69.48,\n" +
            "                \"dewPoint\": 52.97,\n" +
            "                \"humidity\": 0.56,\n" +
            "                \"windSpeed\": 4.87,\n" +
            "                \"windBearing\": 352,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.02,\n" +
            "                \"pressure\": 1013.53,\n" +
            "                \"ozone\": 284.46\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411952400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 67.91,\n" +
            "                \"apparentTemperature\": 67.91,\n" +
            "                \"dewPoint\": 53.26,\n" +
            "                \"humidity\": 0.59,\n" +
            "                \"windSpeed\": 3.99,\n" +
            "                \"windBearing\": 357,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.01,\n" +
            "                \"pressure\": 1013.42,\n" +
            "                \"ozone\": 283.2\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411956000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 65.86,\n" +
            "                \"apparentTemperature\": 65.86,\n" +
            "                \"dewPoint\": 53.7,\n" +
            "                \"humidity\": 0.65,\n" +
            "                \"windSpeed\": 2.76,\n" +
            "                \"windBearing\": 8,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1013.48,\n" +
            "                \"ozone\": 281.66\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411959600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 63.7,\n" +
            "                \"apparentTemperature\": 63.7,\n" +
            "                \"dewPoint\": 53.71,\n" +
            "                \"humidity\": 0.7,\n" +
            "                \"windSpeed\": 1.76,\n" +
            "                \"windBearing\": 33,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1013.57,\n" +
            "                \"ozone\": 280.09\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411963200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 61.83,\n" +
            "                \"apparentTemperature\": 61.83,\n" +
            "                \"dewPoint\": 53.24,\n" +
            "                \"humidity\": 0.73,\n" +
            "                \"windSpeed\": 1.57,\n" +
            "                \"windBearing\": 68,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1013.68,\n" +
            "                \"ozone\": 278.55\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411966800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 61.06,\n" +
            "                \"apparentTemperature\": 61.06,\n" +
            "                \"dewPoint\": 53.49,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 1.75,\n" +
            "                \"windBearing\": 91,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.01,\n" +
            "                \"pressure\": 1013.78,\n" +
            "                \"ozone\": 276.98\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411970400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 60.32,\n" +
            "                \"apparentTemperature\": 60.32,\n" +
            "                \"dewPoint\": 53.58,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 1.88,\n" +
            "                \"windBearing\": 110,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.02,\n" +
            "                \"pressure\": 1013.77,\n" +
            "                \"ozone\": 275.47\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411974000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 59.76,\n" +
            "                \"apparentTemperature\": 59.76,\n" +
            "                \"dewPoint\": 53.72,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 2,\n" +
            "                \"windBearing\": 140,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.07,\n" +
            "                \"pressure\": 1013.55,\n" +
            "                \"ozone\": 273.82\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411977600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 59.57,\n" +
            "                \"apparentTemperature\": 59.57,\n" +
            "                \"dewPoint\": 54.11,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 2.29,\n" +
            "                \"windBearing\": 173,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1013.2,\n" +
            "                \"ozone\": 272.23\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411981200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 58.92,\n" +
            "                \"apparentTemperature\": 58.92,\n" +
            "                \"dewPoint\": 54.04,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 2.99,\n" +
            "                \"windBearing\": 187,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.16,\n" +
            "                \"pressure\": 1012.93,\n" +
            "                \"ozone\": 271.4\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411984800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 57.75,\n" +
            "                \"apparentTemperature\": 57.75,\n" +
            "                \"dewPoint\": 53.59,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 3.69,\n" +
            "                \"windBearing\": 188,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.18,\n" +
            "                \"pressure\": 1012.85,\n" +
            "                \"ozone\": 271.82\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411988400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.35,\n" +
            "                \"apparentTemperature\": 56.35,\n" +
            "                \"dewPoint\": 52.93,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 4.31,\n" +
            "                \"windBearing\": 186,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.19,\n" +
            "                \"pressure\": 1012.87,\n" +
            "                \"ozone\": 273\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411992000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.18,\n" +
            "                \"apparentTemperature\": 55.18,\n" +
            "                \"dewPoint\": 52.3,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 4.82,\n" +
            "                \"windBearing\": 186,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.24,\n" +
            "                \"pressure\": 1012.95,\n" +
            "                \"ozone\": 274.18\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411995600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.35,\n" +
            "                \"apparentTemperature\": 54.35,\n" +
            "                \"dewPoint\": 51.76,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 5.27,\n" +
            "                \"windBearing\": 188,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.35,\n" +
            "                \"pressure\": 1013.06,\n" +
            "                \"ozone\": 275.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411999200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 53.92,\n" +
            "                \"apparentTemperature\": 53.92,\n" +
            "                \"dewPoint\": 51.41,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 5.9,\n" +
            "                \"windBearing\": 191,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.5,\n" +
            "                \"pressure\": 1013.2,\n" +
            "                \"ozone\": 275.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412002800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.29,\n" +
            "                \"apparentTemperature\": 54.29,\n" +
            "                \"dewPoint\": 51.49,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 6.39,\n" +
            "                \"windBearing\": 194,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.63,\n" +
            "                \"pressure\": 1013.3,\n" +
            "                \"ozone\": 277.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412006400,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.68,\n" +
            "                \"apparentTemperature\": 55.68,\n" +
            "                \"dewPoint\": 51.97,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 6.98,\n" +
            "                \"windBearing\": 197,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.73,\n" +
            "                \"pressure\": 1013.35,\n" +
            "                \"ozone\": 278.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412010000,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 57.75,\n" +
            "                \"apparentTemperature\": 57.75,\n" +
            "                \"dewPoint\": 52.76,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 7.6,\n" +
            "                \"windBearing\": 200,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.81,\n" +
            "                \"pressure\": 1013.38,\n" +
            "                \"ozone\": 281.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412013600,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 59.31,\n" +
            "                \"apparentTemperature\": 59.31,\n" +
            "                \"dewPoint\": 53.38,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 7.99,\n" +
            "                \"windBearing\": 202,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1013.37,\n" +
            "                \"ozone\": 282.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412017200,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0026,\n" +
            "                \"precipProbability\": 0.05,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 60.04,\n" +
            "                \"apparentTemperature\": 60.04,\n" +
            "                \"dewPoint\": 53.94,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 8.2,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.87,\n" +
            "                \"pressure\": 1013.27,\n" +
            "                \"ozone\": 284.14\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412020800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0048,\n" +
            "                \"precipProbability\": 0.23,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 60.39,\n" +
            "                \"apparentTemperature\": 60.39,\n" +
            "                \"dewPoint\": 54.48,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 8.36,\n" +
            "                \"windBearing\": 202,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.85,\n" +
            "                \"pressure\": 1013.12,\n" +
            "                \"ozone\": 285.1\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412024400,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0066,\n" +
            "                \"precipProbability\": 0.44,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 60.61,\n" +
            "                \"apparentTemperature\": 60.61,\n" +
            "                \"dewPoint\": 54.71,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 7.89,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.82,\n" +
            "                \"pressure\": 1013.01,\n" +
            "                \"ozone\": 285.62\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412028000,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0072,\n" +
            "                \"precipProbability\": 0.47,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 60.9,\n" +
            "                \"apparentTemperature\": 60.9,\n" +
            "                \"dewPoint\": 54.55,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 5.91,\n" +
            "                \"windBearing\": 208,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1012.97,\n" +
            "                \"ozone\": 285.5\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"daily\": {\n" +
            "        \"summary\": \"Light rain on Monday through Saturday, " +
            "with temperatures bottoming out at 60°F on Wednesday.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411801200,\n" +
            "                \"summary\": \"Partly cloudy throughout the day.\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"sunriseTime\": 1411826655,\n" +
            "                \"sunsetTime\": 1411869528,\n" +
            "                \"moonPhase\": 0.11,\n" +
            "                \"precipIntensity\": 0.0001,\n" +
            "                \"precipIntensityMax\": 0.0013,\n" +
            "                \"precipIntensityMaxTime\": 1411797600,\n" +
            "                \"precipProbability\": 0.09,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 55.34,\n" +
            "                \"temperatureMinTime\": 1411822800,\n" +
            "                \"temperatureMax\": 67.04,\n" +
            "                \"temperatureMaxTime\": 1411858800,\n" +
            "                \"apparentTemperatureMin\": 55.34,\n" +
            "                \"apparentTemperatureMinTime\": 1411822800,\n" +
            "                \"apparentTemperatureMax\": 67.04,\n" +
            "                \"apparentTemperatureMaxTime\": 1411858800,\n" +
            "                \"dewPoint\": 54.34,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 4.08,\n" +
            "                \"windBearing\": 1,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.37,\n" +
            "                \"pressure\": 1019.3,\n" +
            "                \"ozone\": 305.56\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411887600,\n" +
            "                \"summary\": \"Partly cloudy in the morning.\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"sunriseTime\": 1411913136,\n" +
            "                \"sunsetTime\": 1411955805,\n" +
            "                \"moonPhase\": 0.15,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipIntensityMax\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperatureMin\": 53.37,\n" +
            "                \"temperatureMinTime\": 1411912800,\n" +
            "                \"temperatureMax\": 70.15,\n" +
            "                \"temperatureMaxTime\": 1411945200,\n" +
            "                \"apparentTemperatureMin\": 53.37,\n" +
            "                \"apparentTemperatureMinTime\": 1411912800,\n" +
            "                \"apparentTemperatureMax\": 70.15,\n" +
            "                \"apparentTemperatureMaxTime\": 1411945200,\n" +
            "                \"dewPoint\": 52.13,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 3.68,\n" +
            "                \"windBearing\": 6,\n" +
            "                \"visibility\": 9.81,\n" +
            "                \"cloudCover\": 0.18,\n" +
            "                \"pressure\": 1015.95,\n" +
            "                \"ozone\": 284.56\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411974000,\n" +
            "                \"summary\": \"Light rain starting in the afternoon.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1411999618,\n" +
            "                \"sunsetTime\": 1412042081,\n" +
            "                \"moonPhase\": 0.18,\n" +
            "                \"precipIntensity\": 0.0049,\n" +
            "                \"precipIntensityMax\": 0.0185,\n" +
            "                \"precipIntensityMaxTime\": 1412046000,\n" +
            "                \"precipProbability\": 0.86,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 53.92,\n" +
            "                \"temperatureMinTime\": 1411999200,\n" +
            "                \"temperatureMax\": 61.15,\n" +
            "                \"temperatureMaxTime\": 1412031600,\n" +
            "                \"apparentTemperatureMin\": 53.92,\n" +
            "                \"apparentTemperatureMinTime\": 1411999200,\n" +
            "                \"apparentTemperatureMax\": 61.15,\n" +
            "                \"apparentTemperatureMaxTime\": 1412031600,\n" +
            "                \"dewPoint\": 53.29,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 4.85,\n" +
            "                \"windBearing\": 199,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1013.52,\n" +
            "                \"ozone\": 280.89\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412060400,\n" +
            "                \"summary\": \"Light rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412086100,\n" +
            "                \"sunsetTime\": 1412128359,\n" +
            "                \"moonPhase\": 0.22,\n" +
            "                \"precipIntensity\": 0.0106,\n" +
            "                \"precipIntensityMax\": 0.0298,\n" +
            "                \"precipIntensityMaxTime\": 1412110800,\n" +
            "                \"precipProbability\": 0.79,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 52.95,\n" +
            "                \"temperatureMinTime\": 1412085600,\n" +
            "                \"temperatureMax\": 60.66,\n" +
            "                \"temperatureMaxTime\": 1412118000,\n" +
            "                \"apparentTemperatureMin\": 52.95,\n" +
            "                \"apparentTemperatureMinTime\": 1412085600,\n" +
            "                \"apparentTemperatureMax\": 60.66,\n" +
            "                \"apparentTemperatureMaxTime\": 1412118000,\n" +
            "                \"dewPoint\": 50.87,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 2.7,\n" +
            "                \"windBearing\": 214,\n" +
            "                \"visibility\": 8.83,\n" +
            "                \"cloudCover\": 0.61,\n" +
            "                \"pressure\": 1018.47,\n" +
            "                \"ozone\": 281.48\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412146800,\n" +
            "                \"summary\": \"Partly cloudy starting in the afternoon.\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"sunriseTime\": 1412172582,\n" +
            "                \"sunsetTime\": 1412214636,\n" +
            "                \"moonPhase\": 0.25,\n" +
            "                \"precipIntensity\": 0.0014,\n" +
            "                \"precipIntensityMax\": 0.0018,\n" +
            "                \"precipIntensityMaxTime\": 1412146800,\n" +
            "                \"precipProbability\": 0.01,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 51.08,\n" +
            "                \"temperatureMinTime\": 1412172000,\n" +
            "                \"temperatureMax\": 59.73,\n" +
            "                \"temperatureMaxTime\": 1412200800,\n" +
            "                \"apparentTemperatureMin\": 51.08,\n" +
            "                \"apparentTemperatureMinTime\": 1412172000,\n" +
            "                \"apparentTemperatureMax\": 59.73,\n" +
            "                \"apparentTemperatureMaxTime\": 1412200800,\n" +
            "                \"dewPoint\": 49.49,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 2.43,\n" +
            "                \"windBearing\": 169,\n" +
            "                \"cloudCover\": 0.36,\n" +
            "                \"pressure\": 1020.82,\n" +
            "                \"ozone\": 274.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412233200,\n" +
            "                \"summary\": \"Mostly cloudy throughout the day.\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"sunriseTime\": 1412259064,\n" +
            "                \"sunsetTime\": 1412300914,\n" +
            "                \"moonPhase\": 0.29,\n" +
            "                \"precipIntensity\": 0.0012,\n" +
            "                \"precipIntensityMax\": 0.0016,\n" +
            "                \"precipIntensityMaxTime\": 1412294400,\n" +
            "                \"precipProbability\": 0.01,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 48.15,\n" +
            "                \"temperatureMinTime\": 1412251200,\n" +
            "                \"temperatureMax\": 61.97,\n" +
            "                \"temperatureMaxTime\": 1412290800,\n" +
            "                \"apparentTemperatureMin\": 48.15,\n" +
            "                \"apparentTemperatureMinTime\": 1412251200,\n" +
            "                \"apparentTemperatureMax\": 61.97,\n" +
            "                \"apparentTemperatureMaxTime\": 1412290800,\n" +
            "                \"dewPoint\": 47.77,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 1.6,\n" +
            "                \"windBearing\": 31,\n" +
            "                \"cloudCover\": 0.61,\n" +
            "                \"pressure\": 1021.56,\n" +
            "                \"ozone\": 264.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412319600,\n" +
            "                \"summary\": \"Mostly cloudy in the morning.\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"sunriseTime\": 1412345547,\n" +
            "                \"sunsetTime\": 1412387193,\n" +
            "                \"moonPhase\": 0.33,\n" +
            "                \"precipIntensity\": 0.0022,\n" +
            "                \"precipIntensityMax\": 0.0028,\n" +
            "                \"precipIntensityMaxTime\": 1412377200,\n" +
            "                \"precipProbability\": 0.06,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 49.54,\n" +
            "                \"temperatureMinTime\": 1412341200,\n" +
            "                \"temperatureMax\": 68.84,\n" +
            "                \"temperatureMaxTime\": 1412373600,\n" +
            "                \"apparentTemperatureMin\": 49.54,\n" +
            "                \"apparentTemperatureMinTime\": 1412341200,\n" +
            "                \"apparentTemperatureMax\": 68.84,\n" +
            "                \"apparentTemperatureMaxTime\": 1412373600,\n" +
            "                \"dewPoint\": 48.7,\n" +
            "                \"humidity\": 0.72,\n" +
            "                \"windSpeed\": 1.14,\n" +
            "                \"windBearing\": 46,\n" +
            "                \"cloudCover\": 0.37,\n" +
            "                \"pressure\": 1021.85,\n" +
            "                \"ozone\": 261.93\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412406000,\n" +
            "                \"summary\": \"Drizzle starting in the afternoon, " +
            "continuing until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412432030,\n" +
            "                \"sunsetTime\": 1412473472,\n" +
            "                \"moonPhase\": 0.37,\n" +
            "                \"precipIntensity\": 0.0036,\n" +
            "                \"precipIntensityMax\": 0.0053,\n" +
            "                \"precipIntensityMaxTime\": 1412463600,\n" +
            "                \"precipProbability\": 0.2,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 54.27,\n" +
            "                \"temperatureMinTime\": 1412427600,\n" +
            "                \"temperatureMax\": 70.95,\n" +
            "                \"temperatureMaxTime\": 1412463600,\n" +
            "                \"apparentTemperatureMin\": 54.27,\n" +
            "                \"apparentTemperatureMinTime\": 1412427600,\n" +
            "                \"apparentTemperatureMax\": 70.95,\n" +
            "                \"apparentTemperatureMaxTime\": 1412463600,\n" +
            "                \"dewPoint\": 53.52,\n" +
            "                \"humidity\": 0.75,\n" +
            "                \"windSpeed\": 2.07,\n" +
            "                \"windBearing\": 175,\n" +
            "                \"cloudCover\": 0.32,\n" +
            "                \"pressure\": 1020.96,\n" +
            "                \"ozone\": 254.78\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"flags\": {\n" +
            "        \"sources\": [\n" +
            "            \"nwspa\",\n" +
            "            \"darksky\",\n" +
            "            \"isd\",\n" +
            "            \"nearest-precip\",\n" +
            "            \"fnmoc\",\n" +
            "            \"sref\",\n" +
            "            \"rtma\",\n" +
            "            \"rap\",\n" +
            "            \"nam\",\n" +
            "            \"cmc\",\n" +
            "            \"gfs\",\n" +
            "            \"madis\",\n" +
            "            \"lamp\"\n" +
            "        ],\n" +
            "        \"darksky-stations\": [\n" +
            "            \"KATX\"\n" +
            "        ],\n" +
            "        \"isd-stations\": [\n" +
            "            \"727935-24234\",\n" +
            "            \"994014-99999\",\n" +
            "            \"999999-24234\",\n" +
            "            \"999999-24244\",\n" +
            "            \"999999-24281\"\n" +
            "        ],\n" +
            "        \"madis-stations\": [\n" +
            "            \"AS437\",\n" +
            "            \"AU074\",\n" +
            "            \"C1035\",\n" +
            "            \"C1943\",\n" +
            "            \"D3472\",\n" +
            "            \"D4490\",\n" +
            "            \"D4859\",\n" +
            "            \"D6665\",\n" +
            "            \"D6811\",\n" +
            "            \"D8203\",\n" +
            "            \"E3526\",\n" +
            "            \"E3959\",\n" +
            "            \"E5142\",\n" +
            "            \"EBSW1\",\n" +
            "            \"EVERB\",\n" +
            "            \"SEADU\"\n" +
            "        ],\n" +
            "        \"lamp-stations\": [\n" +
            "            \"KAWO\",\n" +
            "            \"KBFI\",\n" +
            "            \"KGRF\",\n" +
            "            \"KPAE\",\n" +
            "            \"KPWT\",\n" +
            "            \"KRNT\",\n" +
            "            \"KSEA\",\n" +
            "            \"KTCM\",\n" +
            "            \"KTIW\"\n" +
            "        ],\n" +
            "        \"units\": \"us\"\n" +
            "    }\n" +
            "}";
}
