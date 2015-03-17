package com.osacky.umbrella.data.api;

import com.google.gson.Gson;
import com.osacky.umbrella.data.api.model.WeatherResult;

import java.util.concurrent.TimeUnit;

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
        return Observable.just(mGson.fromJson(JSON_WEATHER_RAIN, WeatherResult.class))
                .delay(1, TimeUnit.SECONDS);
    }

    @Override
    public Observable<WeatherResult> getWeatherFromCache(@Path("latitude") double latitude, @Path("longitude") double longitude) {
        return Observable.just(mGson.fromJson(JSON_WEATHER_RAIN, WeatherResult.class));
    }

    private static final String JSON_MONTREAL = "{\n" +
            "    \"latitude\": 45.5,\n" +
            "    \"longitude\": -73.56,\n" +
            "    \"timezone\": \"America/Montreal\",\n" +
            "    \"offset\": -4,\n" +
            "    \"currently\": {\n" +
            "        \"time\": 1412479712,\n" +
            "        \"summary\": \"Overcast\",\n" +
            "        \"icon\": \"cloudy\",\n" +
            "        \"nearestStormDistance\": 2,\n" +
            "        \"nearestStormBearing\": 226,\n" +
            "        \"precipIntensity\": 0,\n" +
            "        \"precipProbability\": 0,\n" +
            "        \"temperature\": 52,\n" +
            "        \"apparentTemperature\": 52,\n" +
            "        \"dewPoint\": 49.21,\n" +
            "        \"humidity\": 0.9,\n" +
            "        \"windSpeed\": 6.57,\n" +
            "        \"windBearing\": 211,\n" +
            "        \"visibility\": 5.91,\n" +
            "        \"cloudCover\": 1,\n" +
            "        \"pressure\": 1001.37,\n" +
            "        \"ozone\": 297.75\n" +
            "    },\n" +
            "    \"minutely\": {\n" +
            "        \"summary\": \"Light rain starting in 12 min.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1412479680,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412479740,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412479800,\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412479860,\n" +
            "                \"precipIntensity\": 0.0029,\n" +
            "                \"precipIntensityError\": 0.0015,\n" +
            "                \"precipProbability\": 0.01,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412479920,\n" +
            "                \"precipIntensity\": 0.0034,\n" +
            "                \"precipIntensityError\": 0.0021,\n" +
            "                \"precipProbability\": 0.02,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412479980,\n" +
            "                \"precipIntensity\": 0.0045,\n" +
            "                \"precipIntensityError\": 0.0028,\n" +
            "                \"precipProbability\": 0.06,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480040,\n" +
            "                \"precipIntensity\": 0.0052,\n" +
            "                \"precipIntensityError\": 0.003,\n" +
            "                \"precipProbability\": 0.11,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480100,\n" +
            "                \"precipIntensity\": 0.0056,\n" +
            "                \"precipIntensityError\": 0.0031,\n" +
            "                \"precipProbability\": 0.17,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480160,\n" +
            "                \"precipIntensity\": 0.0059,\n" +
            "                \"precipIntensityError\": 0.0033,\n" +
            "                \"precipProbability\": 0.25,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480220,\n" +
            "                \"precipIntensity\": 0.0055,\n" +
            "                \"precipIntensityError\": 0.0031,\n" +
            "                \"precipProbability\": 0.22,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480280,\n" +
            "                \"precipIntensity\": 0.0056,\n" +
            "                \"precipIntensityError\": 0.0033,\n" +
            "                \"precipProbability\": 0.27,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480340,\n" +
            "                \"precipIntensity\": 0.0061,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 0.29,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480400,\n" +
            "                \"precipIntensity\": 0.0063,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 0.31,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480460,\n" +
            "                \"precipIntensity\": 0.0071,\n" +
            "                \"precipIntensityError\": 0.0042,\n" +
            "                \"precipProbability\": 0.36,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480520,\n" +
            "                \"precipIntensity\": 0.0088,\n" +
            "                \"precipIntensityError\": 0.0048,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480580,\n" +
            "                \"precipIntensity\": 0.0099,\n" +
            "                \"precipIntensityError\": 0.0051,\n" +
            "                \"precipProbability\": 0.53,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480640,\n" +
            "                \"precipIntensity\": 0.0119,\n" +
            "                \"precipIntensityError\": 0.0056,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480700,\n" +
            "                \"precipIntensity\": 0.0124,\n" +
            "                \"precipIntensityError\": 0.0057,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480760,\n" +
            "                \"precipIntensity\": 0.0135,\n" +
            "                \"precipIntensityError\": 0.0059,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480820,\n" +
            "                \"precipIntensity\": 0.0148,\n" +
            "                \"precipIntensityError\": 0.0061,\n" +
            "                \"precipProbability\": 0.59,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480880,\n" +
            "                \"precipIntensity\": 0.0153,\n" +
            "                \"precipIntensityError\": 0.006,\n" +
            "                \"precipProbability\": 0.6,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412480940,\n" +
            "                \"precipIntensity\": 0.0156,\n" +
            "                \"precipIntensityError\": 0.0059,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481000,\n" +
            "                \"precipIntensity\": 0.0157,\n" +
            "                \"precipIntensityError\": 0.0058,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481060,\n" +
            "                \"precipIntensity\": 0.0155,\n" +
            "                \"precipIntensityError\": 0.0055,\n" +
            "                \"precipProbability\": 0.65,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481120,\n" +
            "                \"precipIntensity\": 0.0149,\n" +
            "                \"precipIntensityError\": 0.0052,\n" +
            "                \"precipProbability\": 0.66,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481180,\n" +
            "                \"precipIntensity\": 0.015,\n" +
            "                \"precipIntensityError\": 0.005,\n" +
            "                \"precipProbability\": 0.68,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481240,\n" +
            "                \"precipIntensity\": 0.0141,\n" +
            "                \"precipIntensityError\": 0.0047,\n" +
            "                \"precipProbability\": 0.69,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481300,\n" +
            "                \"precipIntensity\": 0.0126,\n" +
            "                \"precipIntensityError\": 0.0043,\n" +
            "                \"precipProbability\": 0.71,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481360,\n" +
            "                \"precipIntensity\": 0.0118,\n" +
            "                \"precipIntensityError\": 0.0042,\n" +
            "                \"precipProbability\": 0.72,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481420,\n" +
            "                \"precipIntensity\": 0.0108,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 0.73,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481480,\n" +
            "                \"precipIntensity\": 0.01,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 0.74,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481540,\n" +
            "                \"precipIntensity\": 0.0091,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 0.74,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481600,\n" +
            "                \"precipIntensity\": 0.0086,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 0.7,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481660,\n" +
            "                \"precipIntensity\": 0.0082,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 0.66,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481720,\n" +
            "                \"precipIntensity\": 0.0079,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 0.64,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481780,\n" +
            "                \"precipIntensity\": 0.0077,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481840,\n" +
            "                \"precipIntensity\": 0.0174,\n" +
            "                \"precipIntensityError\": 0.0035,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481900,\n" +
            "                \"precipIntensity\": 0.0171,\n" +
            "                \"precipIntensityError\": 0.0034,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481960,\n" +
            "                \"precipIntensity\": 0.0069,\n" +
            "                \"precipIntensityError\": 0.0034,\n" +
            "                \"precipProbability\": 0.53,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482020,\n" +
            "                \"precipIntensity\": 0.0067,\n" +
            "                \"precipIntensityError\": 0.0034,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482080,\n" +
            "                \"precipIntensity\": 0.0067,\n" +
            "                \"precipIntensityError\": 0.0035,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482140,\n" +
            "                \"precipIntensity\": 0.0067,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482200,\n" +
            "                \"precipIntensity\": 0.0068,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482260,\n" +
            "                \"precipIntensity\": 0.0069,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482320,\n" +
            "                \"precipIntensity\": 0.0071,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482380,\n" +
            "                \"precipIntensity\": 0.0073,\n" +
            "                \"precipIntensityError\": 0.0042,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482440,\n" +
            "                \"precipIntensity\": 0.0075,\n" +
            "                \"precipIntensityError\": 0.0043,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482500,\n" +
            "                \"precipIntensity\": 0.0076,\n" +
            "                \"precipIntensityError\": 0.0044,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482560,\n" +
            "                \"precipIntensity\": 0.008,\n" +
            "                \"precipIntensityError\": 0.0047,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482620,\n" +
            "                \"precipIntensity\": 0.0082,\n" +
            "                \"precipIntensityError\": 0.0048,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482680,\n" +
            "                \"precipIntensity\": 0.0084,\n" +
            "                \"precipIntensityError\": 0.0049,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482740,\n" +
            "                \"precipIntensity\": 0.0088,\n" +
            "                \"precipIntensityError\": 0.005,\n" +
            "                \"precipProbability\": 0.52,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482800,\n" +
            "                \"precipIntensity\": 0.0091,\n" +
            "                \"precipIntensityError\": 0.0051,\n" +
            "                \"precipProbability\": 0.53,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482860,\n" +
            "                \"precipIntensity\": 0.0095,\n" +
            "                \"precipIntensityError\": 0.0053,\n" +
            "                \"precipProbability\": 0.52,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482920,\n" +
            "                \"precipIntensity\": 0.0099,\n" +
            "                \"precipIntensityError\": 0.0054,\n" +
            "                \"precipProbability\": 0.51,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412482980,\n" +
            "                \"precipIntensity\": 0.0104,\n" +
            "                \"precipIntensityError\": 0.0057,\n" +
            "                \"precipProbability\": 0.51,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412483040,\n" +
            "                \"precipIntensity\": 0.0108,\n" +
            "                \"precipIntensityError\": 0.0058,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412483100,\n" +
            "                \"precipIntensity\": 0.0112,\n" +
            "                \"precipIntensityError\": 0.006,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412483160,\n" +
            "                \"precipIntensity\": 0.0119,\n" +
            "                \"precipIntensityError\": 0.0063,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412483220,\n" +
            "                \"precipIntensity\": 0.0124,\n" +
            "                \"precipIntensityError\": 0.0066,\n" +
            "                \"precipProbability\": 0.47,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412483280,\n" +
            "                \"precipIntensity\": 0.0127,\n" +
            "                \"precipIntensityError\": 0.0067,\n" +
            "                \"precipProbability\": 0.47,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"hourly\": {\n" +
            "        \"summary\": \"Light rain later tonight.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1412478000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0169,\n" +
            "                \"precipProbability\": 0.9,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 52.58,\n" +
            "                \"apparentTemperature\": 52.58,\n" +
            "                \"dewPoint\": 49.7,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 5.98,\n" +
            "                \"windBearing\": 214,\n" +
            "                \"visibility\": 5.59,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.32,\n" +
            "                \"ozone\": 297.25\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0092,\n" +
            "                \"precipProbability\": 0.79,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 51.36,\n" +
            "                \"apparentTemperature\": 51.36,\n" +
            "                \"dewPoint\": 48.68,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 7.24,\n" +
            "                \"windBearing\": 209,\n" +
            "                \"visibility\": 6.25,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.43,\n" +
            "                \"ozone\": 298.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412485200,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.008,\n" +
            "                \"precipProbability\": 0.46,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 51.05,\n" +
            "                \"apparentTemperature\": 51.05,\n" +
            "                \"dewPoint\": 48.16,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 8.56,\n" +
            "                \"windBearing\": 213,\n" +
            "                \"visibility\": 6.67,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.44,\n" +
            "                \"ozone\": 299\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412488800,\n" +
            "                \"summary\": \"Overcast\",\n" +
            "                \"icon\": \"cloudy\",\n" +
            "                \"precipIntensity\": 0.0034,\n" +
            "                \"precipProbability\": 0.04,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 50.36,\n" +
            "                \"apparentTemperature\": 50.36,\n" +
            "                \"dewPoint\": 46.96,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 9.78,\n" +
            "                \"windBearing\": 217,\n" +
            "                \"visibility\": 7.36,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.47,\n" +
            "                \"ozone\": 299.71\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412492400,\n" +
            "                \"summary\": \"Overcast\",\n" +
            "                \"icon\": \"cloudy\",\n" +
            "                \"precipIntensity\": 0.0044,\n" +
            "                \"precipProbability\": 0.04,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 49.58,\n" +
            "                \"apparentTemperature\": 45.42,\n" +
            "                \"dewPoint\": 45.89,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 10.29,\n" +
            "                \"windBearing\": 218,\n" +
            "                \"visibility\": 7.89,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.61,\n" +
            "                \"ozone\": 299.88\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412496000,\n" +
            "                \"summary\": \"Overcast\",\n" +
            "                \"icon\": \"cloudy\",\n" +
            "                \"precipIntensity\": 0.0024,\n" +
            "                \"precipProbability\": 0.02,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 48.62,\n" +
            "                \"apparentTemperature\": 44.48,\n" +
            "                \"dewPoint\": 44.75,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 9.59,\n" +
            "                \"windBearing\": 218,\n" +
            "                \"visibility\": 8.05,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1001.85,\n" +
            "                \"ozone\": 300.07\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412499600,\n" +
            "                \"summary\": \"Overcast\",\n" +
            "                \"icon\": \"cloudy\",\n" +
            "                \"precipIntensity\": 0.0019,\n" +
            "                \"precipProbability\": 0.01,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 47.75,\n" +
            "                \"apparentTemperature\": 43.87,\n" +
            "                \"dewPoint\": 43.95,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 8.39,\n" +
            "                \"windBearing\": 219,\n" +
            "                \"visibility\": 8.4,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1002.21,\n" +
            "                \"ozone\": 302.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412503200,\n" +
            "                \"summary\": \"Overcast\",\n" +
            "                \"icon\": \"cloudy\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 47.07,\n" +
            "                \"apparentTemperature\": 42.74,\n" +
            "                \"dewPoint\": 43.44,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 9.09,\n" +
            "                \"windBearing\": 218,\n" +
            "                \"visibility\": 8.22,\n" +
            "                \"cloudCover\": 0.97,\n" +
            "                \"pressure\": 1002.67,\n" +
            "                \"ozone\": 308.36\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412506800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 46.38,\n" +
            "                \"apparentTemperature\": 41.69,\n" +
            "                \"dewPoint\": 42.81,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 9.62,\n" +
            "                \"windBearing\": 222,\n" +
            "                \"visibility\": 8.01,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1003.22,\n" +
            "                \"ozone\": 316.46\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412510400,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 45.89,\n" +
            "                \"apparentTemperature\": 40.75,\n" +
            "                \"dewPoint\": 41.77,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 10.53,\n" +
            "                \"windBearing\": 222,\n" +
            "                \"visibility\": 8.08,\n" +
            "                \"cloudCover\": 0.82,\n" +
            "                \"pressure\": 1003.78,\n" +
            "                \"ozone\": 323.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412514000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 47.16,\n" +
            "                \"apparentTemperature\": 41.78,\n" +
            "                \"dewPoint\": 41.43,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 12.23,\n" +
            "                \"windBearing\": 220,\n" +
            "                \"visibility\": 8.48,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1004.33,\n" +
            "                \"ozone\": 328.43\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412517600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 49.16,\n" +
            "                \"apparentTemperature\": 43.99,\n" +
            "                \"dewPoint\": 40.81,\n" +
            "                \"humidity\": 0.73,\n" +
            "                \"windSpeed\": 13.37,\n" +
            "                \"windBearing\": 220,\n" +
            "                \"visibility\": 9.27,\n" +
            "                \"cloudCover\": 0.24,\n" +
            "                \"pressure\": 1004.82,\n" +
            "                \"ozone\": 332.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412521200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 51.17,\n" +
            "                \"apparentTemperature\": 51.17,\n" +
            "                \"dewPoint\": 40.07,\n" +
            "                \"humidity\": 0.66,\n" +
            "                \"windSpeed\": 14.19,\n" +
            "                \"windBearing\": 220,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.01,\n" +
            "                \"pressure\": 1005.23,\n" +
            "                \"ozone\": 332.86\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412524800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 53.07,\n" +
            "                \"apparentTemperature\": 53.07,\n" +
            "                \"dewPoint\": 39.67,\n" +
            "                \"humidity\": 0.6,\n" +
            "                \"windSpeed\": 14.22,\n" +
            "                \"windBearing\": 222,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1005.48,\n" +
            "                \"ozone\": 327.57\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412528400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.67,\n" +
            "                \"apparentTemperature\": 54.67,\n" +
            "                \"dewPoint\": 39.56,\n" +
            "                \"humidity\": 0.57,\n" +
            "                \"windSpeed\": 14.04,\n" +
            "                \"windBearing\": 219,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.06,\n" +
            "                \"pressure\": 1005.64,\n" +
            "                \"ozone\": 318.98\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412532000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.06,\n" +
            "                \"apparentTemperature\": 56.06,\n" +
            "                \"dewPoint\": 39.26,\n" +
            "                \"humidity\": 0.53,\n" +
            "                \"windSpeed\": 13.24,\n" +
            "                \"windBearing\": 216,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1005.84,\n" +
            "                \"ozone\": 312.74\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412535600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.57,\n" +
            "                \"apparentTemperature\": 56.57,\n" +
            "                \"dewPoint\": 38.64,\n" +
            "                \"humidity\": 0.51,\n" +
            "                \"windSpeed\": 13.34,\n" +
            "                \"windBearing\": 213,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.13,\n" +
            "                \"pressure\": 1006.12,\n" +
            "                \"ozone\": 311.62\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412539200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.44,\n" +
            "                \"apparentTemperature\": 56.44,\n" +
            "                \"dewPoint\": 38.52,\n" +
            "                \"humidity\": 0.51,\n" +
            "                \"windSpeed\": 13.15,\n" +
            "                \"windBearing\": 213,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1006.46,\n" +
            "                \"ozone\": 312.85\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412542800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.74,\n" +
            "                \"apparentTemperature\": 55.74,\n" +
            "                \"dewPoint\": 39.33,\n" +
            "                \"humidity\": 0.54,\n" +
            "                \"windSpeed\": 12.11,\n" +
            "                \"windBearing\": 215,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1006.95,\n" +
            "                \"ozone\": 313.86\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412546400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 54.05,\n" +
            "                \"apparentTemperature\": 54.05,\n" +
            "                \"dewPoint\": 40.28,\n" +
            "                \"humidity\": 0.6,\n" +
            "                \"windSpeed\": 10.22,\n" +
            "                \"windBearing\": 215,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.11,\n" +
            "                \"pressure\": 1007.69,\n" +
            "                \"ozone\": 313.67\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412550000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 51.66,\n" +
            "                \"apparentTemperature\": 51.66,\n" +
            "                \"dewPoint\": 40.98,\n" +
            "                \"humidity\": 0.67,\n" +
            "                \"windSpeed\": 8.51,\n" +
            "                \"windBearing\": 213,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.12,\n" +
            "                \"pressure\": 1008.54,\n" +
            "                \"ozone\": 313.27\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412553600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 49.39,\n" +
            "                \"apparentTemperature\": 46.21,\n" +
            "                \"dewPoint\": 41.04,\n" +
            "                \"humidity\": 0.73,\n" +
            "                \"windSpeed\": 7.55,\n" +
            "                \"windBearing\": 209,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.13,\n" +
            "                \"pressure\": 1009.32,\n" +
            "                \"ozone\": 313.06\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412557200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 47.85,\n" +
            "                \"apparentTemperature\": 44.97,\n" +
            "                \"dewPoint\": 40.94,\n" +
            "                \"humidity\": 0.77,\n" +
            "                \"windSpeed\": 6.25,\n" +
            "                \"windBearing\": 204,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.14,\n" +
            "                \"pressure\": 1009.96,\n" +
            "                \"ozone\": 313.28\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412560800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 47.04,\n" +
            "                \"apparentTemperature\": 44.08,\n" +
            "                \"dewPoint\": 40.86,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 6.12,\n" +
            "                \"windBearing\": 197,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.15,\n" +
            "                \"pressure\": 1010.55,\n" +
            "                \"ozone\": 313.7\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412564400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 46.33,\n" +
            "                \"apparentTemperature\": 43.3,\n" +
            "                \"dewPoint\": 40.75,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 5.98,\n" +
            "                \"windBearing\": 190,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.19,\n" +
            "                \"pressure\": 1011.09,\n" +
            "                \"ozone\": 313.98\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412568000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 45.61,\n" +
            "                \"apparentTemperature\": 42.63,\n" +
            "                \"dewPoint\": 40.56,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 5.68,\n" +
            "                \"windBearing\": 182,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.29,\n" +
            "                \"pressure\": 1011.6,\n" +
            "                \"ozone\": 313.87\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412571600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 44.92,\n" +
            "                \"apparentTemperature\": 41.99,\n" +
            "                \"dewPoint\": 40.28,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 5.39,\n" +
            "                \"windBearing\": 174,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.42,\n" +
            "                \"pressure\": 1012.06,\n" +
            "                \"ozone\": 313.61\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412575200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 44,\n" +
            "                \"apparentTemperature\": 41.01,\n" +
            "                \"dewPoint\": 39.73,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 5.25,\n" +
            "                \"windBearing\": 165,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.49,\n" +
            "                \"pressure\": 1012.44,\n" +
            "                \"ozone\": 313.65\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412578800,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 43.05,\n" +
            "                \"apparentTemperature\": 39.87,\n" +
            "                \"dewPoint\": 39.25,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 5.27,\n" +
            "                \"windBearing\": 154,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.41,\n" +
            "                \"pressure\": 1012.71,\n" +
            "                \"ozone\": 314.26\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412582400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 42.19,\n" +
            "                \"apparentTemperature\": 38.78,\n" +
            "                \"dewPoint\": 38.83,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 5.38,\n" +
            "                \"windBearing\": 143,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.27,\n" +
            "                \"pressure\": 1012.91,\n" +
            "                \"ozone\": 315.16\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412586000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 41.72,\n" +
            "                \"apparentTemperature\": 38.04,\n" +
            "                \"dewPoint\": 38.43,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 5.63,\n" +
            "                \"windBearing\": 136,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.2,\n" +
            "                \"pressure\": 1013.13,\n" +
            "                \"ozone\": 315.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412589600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 41.61,\n" +
            "                \"apparentTemperature\": 37.68,\n" +
            "                \"dewPoint\": 37.93,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 5.99,\n" +
            "                \"windBearing\": 134,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.36,\n" +
            "                \"pressure\": 1013.43,\n" +
            "                \"ozone\": 316.77\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412593200,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 42.68,\n" +
            "                \"apparentTemperature\": 38.71,\n" +
            "                \"dewPoint\": 38.19,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 6.39,\n" +
            "                \"windBearing\": 136,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.62,\n" +
            "                \"pressure\": 1013.76,\n" +
            "                \"ozone\": 317.47\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412596800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 44.35,\n" +
            "                \"apparentTemperature\": 40.37,\n" +
            "                \"dewPoint\": 38.51,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 7.02,\n" +
            "                \"windBearing\": 139,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.74,\n" +
            "                \"pressure\": 1014.02,\n" +
            "                \"ozone\": 317.18\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412600400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 47.71,\n" +
            "                \"apparentTemperature\": 43.95,\n" +
            "                \"dewPoint\": 39.41,\n" +
            "                \"humidity\": 0.73,\n" +
            "                \"windSpeed\": 8.07,\n" +
            "                \"windBearing\": 145,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.55,\n" +
            "                \"pressure\": 1014.21,\n" +
            "                \"ozone\": 315.15\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412604000,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 52.3,\n" +
            "                \"apparentTemperature\": 52.3,\n" +
            "                \"dewPoint\": 40.51,\n" +
            "                \"humidity\": 0.64,\n" +
            "                \"windSpeed\": 9.45,\n" +
            "                \"windBearing\": 150,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.22,\n" +
            "                \"pressure\": 1014.32,\n" +
            "                \"ozone\": 312.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412607600,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 56.09,\n" +
            "                \"apparentTemperature\": 56.09,\n" +
            "                \"dewPoint\": 40.85,\n" +
            "                \"humidity\": 0.57,\n" +
            "                \"windSpeed\": 10.77,\n" +
            "                \"windBearing\": 152,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.01,\n" +
            "                \"pressure\": 1014.27,\n" +
            "                \"ozone\": 309.49\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412611200,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 58.46,\n" +
            "                \"apparentTemperature\": 58.46,\n" +
            "                \"dewPoint\": 40.42,\n" +
            "                \"humidity\": 0.51,\n" +
            "                \"windSpeed\": 12.08,\n" +
            "                \"windBearing\": 152,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.02,\n" +
            "                \"pressure\": 1013.95,\n" +
            "                \"ozone\": 307.71\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412614800,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 60.04,\n" +
            "                \"apparentTemperature\": 60.04,\n" +
            "                \"dewPoint\": 39.79,\n" +
            "                \"humidity\": 0.47,\n" +
            "                \"windSpeed\": 13.41,\n" +
            "                \"windBearing\": 150,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.11,\n" +
            "                \"pressure\": 1013.49,\n" +
            "                \"ozone\": 306.34\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412618400,\n" +
            "                \"summary\": \"Clear\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 60.92,\n" +
            "                \"apparentTemperature\": 60.92,\n" +
            "                \"dewPoint\": 39.78,\n" +
            "                \"humidity\": 0.46,\n" +
            "                \"windSpeed\": 14.21,\n" +
            "                \"windBearing\": 149,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.24,\n" +
            "                \"pressure\": 1013.12,\n" +
            "                \"ozone\": 305.4\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412622000,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 60.91,\n" +
            "                \"apparentTemperature\": 60.91,\n" +
            "                \"dewPoint\": 40.95,\n" +
            "                \"humidity\": 0.48,\n" +
            "                \"windSpeed\": 13.79,\n" +
            "                \"windBearing\": 148,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.43,\n" +
            "                \"pressure\": 1012.98,\n" +
            "                \"ozone\": 304.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412625600,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0029,\n" +
            "                \"precipProbability\": 0.02,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 60.21,\n" +
            "                \"apparentTemperature\": 60.21,\n" +
            "                \"dewPoint\": 42.57,\n" +
            "                \"humidity\": 0.52,\n" +
            "                \"windSpeed\": 12.47,\n" +
            "                \"windBearing\": 145,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.66,\n" +
            "                \"pressure\": 1012.95,\n" +
            "                \"ozone\": 305.02\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412629200,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.004,\n" +
            "                \"precipProbability\": 0.04,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 59.27,\n" +
            "                \"apparentTemperature\": 59.27,\n" +
            "                \"dewPoint\": 43.7,\n" +
            "                \"humidity\": 0.56,\n" +
            "                \"windSpeed\": 11.5,\n" +
            "                \"windBearing\": 142,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1012.98,\n" +
            "                \"ozone\": 305.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412632800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0043,\n" +
            "                \"precipProbability\": 0.05,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 57.94,\n" +
            "                \"apparentTemperature\": 57.94,\n" +
            "                \"dewPoint\": 43.97,\n" +
            "                \"humidity\": 0.6,\n" +
            "                \"windSpeed\": 11.8,\n" +
            "                \"windBearing\": 139,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.78,\n" +
            "                \"pressure\": 1013.07,\n" +
            "                \"ozone\": 305.87\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412636400,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0.004,\n" +
            "                \"precipProbability\": 0.05,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 56.63,\n" +
            "                \"apparentTemperature\": 56.63,\n" +
            "                \"dewPoint\": 44.06,\n" +
            "                \"humidity\": 0.63,\n" +
            "                \"windSpeed\": 11.64,\n" +
            "                \"windBearing\": 133,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.68,\n" +
            "                \"pressure\": 1013.27,\n" +
            "                \"ozone\": 306.69\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412640000,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0.0035,\n" +
            "                \"precipProbability\": 0.04,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 56.03,\n" +
            "                \"apparentTemperature\": 56.03,\n" +
            "                \"dewPoint\": 44.6,\n" +
            "                \"humidity\": 0.65,\n" +
            "                \"windSpeed\": 11.88,\n" +
            "                \"windBearing\": 131,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.6,\n" +
            "                \"pressure\": 1013.46,\n" +
            "                \"ozone\": 307.54\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412643600,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0.002,\n" +
            "                \"precipProbability\": 0.01,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 55.79,\n" +
            "                \"apparentTemperature\": 55.79,\n" +
            "                \"dewPoint\": 45.16,\n" +
            "                \"humidity\": 0.67,\n" +
            "                \"windSpeed\": 12.52,\n" +
            "                \"windBearing\": 134,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.52,\n" +
            "                \"pressure\": 1013.72,\n" +
            "                \"ozone\": 308.63\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412647200,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.65,\n" +
            "                \"apparentTemperature\": 55.65,\n" +
            "                \"dewPoint\": 45.68,\n" +
            "                \"humidity\": 0.69,\n" +
            "                \"windSpeed\": 13.44,\n" +
            "                \"windBearing\": 138,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.48,\n" +
            "                \"pressure\": 1014.02,\n" +
            "                \"ozone\": 309.75\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412650800,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 55.5,\n" +
            "                \"apparentTemperature\": 55.5,\n" +
            "                \"dewPoint\": 46.38,\n" +
            "                \"humidity\": 0.71,\n" +
            "                \"windSpeed\": 14.15,\n" +
            "                \"windBearing\": 141,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.51,\n" +
            "                \"pressure\": 1014.24,\n" +
            "                \"ozone\": 310.1\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"daily\": {\n" +
            "        \"summary\": \"Light rain today through Friday, with temperatures peaking at 63°F on Tuesday.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1412395200,\n" +
            "                \"summary\": \"Rain throughout the day.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412420242,\n" +
            "                \"sunsetTime\": 1412461854,\n" +
            "                \"moonPhase\": 0.36,\n" +
            "                \"precipIntensity\": 0.0307,\n" +
            "                \"precipIntensityMax\": 0.1002,\n" +
            "                \"precipIntensityMaxTime\": 1412434800,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 52.58,\n" +
            "                \"temperatureMinTime\": 1412478000,\n" +
            "                \"temperatureMax\": 60.02,\n" +
            "                \"temperatureMaxTime\": 1412395200,\n" +
            "                \"apparentTemperatureMin\": 52.58,\n" +
            "                \"apparentTemperatureMinTime\": 1412478000,\n" +
            "                \"apparentTemperatureMax\": 60.02,\n" +
            "                \"apparentTemperatureMaxTime\": 1412395200,\n" +
            "                \"dewPoint\": 51.45,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 5,\n" +
            "                \"windBearing\": 148,\n" +
            "                \"visibility\": 7.55,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1002.15,\n" +
            "                \"ozone\": 279.34\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481600,\n" +
            "                \"summary\": \"Mostly cloudy in the morning.\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"sunriseTime\": 1412506718,\n" +
            "                \"sunsetTime\": 1412548140,\n" +
            "                \"moonPhase\": 0.4,\n" +
            "                \"precipIntensity\": 0.0015,\n" +
            "                \"precipIntensityMax\": 0.0092,\n" +
            "                \"precipIntensityMaxTime\": 1412481600,\n" +
            "                \"precipProbability\": 0.79,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 45.89,\n" +
            "                \"temperatureMinTime\": 1412510400,\n" +
            "                \"temperatureMax\": 56.57,\n" +
            "                \"temperatureMaxTime\": 1412535600,\n" +
            "                \"apparentTemperatureMin\": 40.75,\n" +
            "                \"apparentTemperatureMinTime\": 1412510400,\n" +
            "                \"apparentTemperatureMax\": 56.57,\n" +
            "                \"apparentTemperatureMaxTime\": 1412535600,\n" +
            "                \"dewPoint\": 42.02,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 10.25,\n" +
            "                \"windBearing\": 216,\n" +
            "                \"visibility\": 9.03,\n" +
            "                \"cloudCover\": 0.45,\n" +
            "                \"pressure\": 1005.32,\n" +
            "                \"ozone\": 313.31\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412568000,\n" +
            "                \"summary\": \"Light rain overnight.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412593194,\n" +
            "                \"sunsetTime\": 1412634427,\n" +
            "                \"moonPhase\": 0.44,\n" +
            "                \"precipIntensity\": 0.0009,\n" +
            "                \"precipIntensityMax\": 0.0043,\n" +
            "                \"precipIntensityMaxTime\": 1412632800,\n" +
            "                \"precipProbability\": 0.05,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 41.61,\n" +
            "                \"temperatureMinTime\": 1412589600,\n" +
            "                \"temperatureMax\": 60.92,\n" +
            "                \"temperatureMaxTime\": 1412618400,\n" +
            "                \"apparentTemperatureMin\": 37.68,\n" +
            "                \"apparentTemperatureMinTime\": 1412589600,\n" +
            "                \"apparentTemperatureMax\": 60.92,\n" +
            "                \"apparentTemperatureMaxTime\": 1412618400,\n" +
            "                \"dewPoint\": 41.23,\n" +
            "                \"humidity\": 0.69,\n" +
            "                \"windSpeed\": 9.56,\n" +
            "                \"windBearing\": 145,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.43,\n" +
            "                \"pressure\": 1013.34,\n" +
            "                \"ozone\": 310.75\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412654400,\n" +
            "                \"summary\": \"Light rain in the morning and overnight.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412679670,\n" +
            "                \"sunsetTime\": 1412720715,\n" +
            "                \"moonPhase\": 0.47,\n" +
            "                \"precipIntensity\": 0.0143,\n" +
            "                \"precipIntensityMax\": 0.0342,\n" +
            "                \"precipIntensityMaxTime\": 1412701200,\n" +
            "                \"precipProbability\": 0.86,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 53.99,\n" +
            "                \"temperatureMinTime\": 1412676000,\n" +
            "                \"temperatureMax\": 62.51,\n" +
            "                \"temperatureMaxTime\": 1412715600,\n" +
            "                \"apparentTemperatureMin\": 53.99,\n" +
            "                \"apparentTemperatureMinTime\": 1412676000,\n" +
            "                \"apparentTemperatureMax\": 62.51,\n" +
            "                \"apparentTemperatureMaxTime\": 1412715600,\n" +
            "                \"dewPoint\": 52.05,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 11.67,\n" +
            "                \"windBearing\": 150,\n" +
            "                \"visibility\": 9.28,\n" +
            "                \"cloudCover\": 0.9,\n" +
            "                \"pressure\": 1012.8,\n" +
            "                \"ozone\": 306.1\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412740800,\n" +
            "                \"summary\": \"Light rain throughout the day.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412766147,\n" +
            "                \"sunsetTime\": 1412807003,\n" +
            "                \"moonPhase\": 0.51,\n" +
            "                \"precipIntensity\": 0.0155,\n" +
            "                \"precipIntensityMax\": 0.0313,\n" +
            "                \"precipIntensityMaxTime\": 1412758800,\n" +
            "                \"precipProbability\": 0.82,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 50.14,\n" +
            "                \"temperatureMinTime\": 1412823600,\n" +
            "                \"temperatureMax\": 58.48,\n" +
            "                \"temperatureMaxTime\": 1412791200,\n" +
            "                \"apparentTemperatureMin\": 50.14,\n" +
            "                \"apparentTemperatureMinTime\": 1412823600,\n" +
            "                \"apparentTemperatureMax\": 58.48,\n" +
            "                \"apparentTemperatureMaxTime\": 1412791200,\n" +
            "                \"dewPoint\": 51.39,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 5.04,\n" +
            "                \"windBearing\": 213,\n" +
            "                \"visibility\": 5.47,\n" +
            "                \"cloudCover\": 0.77,\n" +
            "                \"pressure\": 1009.29,\n" +
            "                \"ozone\": 312.42\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412827200,\n" +
            "                \"summary\": \"Drizzle in the afternoon.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412852625,\n" +
            "                \"sunsetTime\": 1412893292,\n" +
            "                \"moonPhase\": 0.55,\n" +
            "                \"precipIntensity\": 0.0028,\n" +
            "                \"precipIntensityMax\": 0.0059,\n" +
            "                \"precipIntensityMaxTime\": 1412877600,\n" +
            "                \"precipProbability\": 0.26,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 41.12,\n" +
            "                \"temperatureMinTime\": 1412856000,\n" +
            "                \"temperatureMax\": 51.94,\n" +
            "                \"temperatureMaxTime\": 1412884800,\n" +
            "                \"apparentTemperatureMin\": 36.03,\n" +
            "                \"apparentTemperatureMinTime\": 1412856000,\n" +
            "                \"apparentTemperatureMax\": 51.94,\n" +
            "                \"apparentTemperatureMaxTime\": 1412884800,\n" +
            "                \"dewPoint\": 41.55,\n" +
            "                \"humidity\": 0.82,\n" +
            "                \"windSpeed\": 8.39,\n" +
            "                \"windBearing\": 251,\n" +
            "                \"cloudCover\": 0.27,\n" +
            "                \"pressure\": 1015.32,\n" +
            "                \"ozone\": 305.1\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412913600,\n" +
            "                \"summary\": \"Drizzle in the evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412939102,\n" +
            "                \"sunsetTime\": 1412979582,\n" +
            "                \"moonPhase\": 0.58,\n" +
            "                \"precipIntensity\": 0.0036,\n" +
            "                \"precipIntensityMax\": 0.0056,\n" +
            "                \"precipIntensityMaxTime\": 1412978400,\n" +
            "                \"precipProbability\": 0.24,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 40.73,\n" +
            "                \"temperatureMinTime\": 1412938800,\n" +
            "                \"temperatureMax\": 49.39,\n" +
            "                \"temperatureMaxTime\": 1412971200,\n" +
            "                \"apparentTemperatureMin\": 38.41,\n" +
            "                \"apparentTemperatureMinTime\": 1412938800,\n" +
            "                \"apparentTemperatureMax\": 49.39,\n" +
            "                \"apparentTemperatureMaxTime\": 1412971200,\n" +
            "                \"dewPoint\": 42.24,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 1.68,\n" +
            "                \"windBearing\": 239,\n" +
            "                \"cloudCover\": 0.72,\n" +
            "                \"pressure\": 1014.32,\n" +
            "                \"ozone\": 297.14\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1413000000,\n" +
            "                \"summary\": \"Partly cloudy throughout the day.\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"sunriseTime\": 1413025580,\n" +
            "                \"sunsetTime\": 1413065872,\n" +
            "                \"moonPhase\": 0.62,\n" +
            "                \"precipIntensity\": 0.003,\n" +
            "                \"precipIntensityMax\": 0.0041,\n" +
            "                \"precipIntensityMaxTime\": 1413050400,\n" +
            "                \"precipProbability\": 0.13,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 37.57,\n" +
            "                \"temperatureMinTime\": 1413025200,\n" +
            "                \"temperatureMax\": 50.97,\n" +
            "                \"temperatureMaxTime\": 1413054000,\n" +
            "                \"apparentTemperatureMin\": 35.35,\n" +
            "                \"apparentTemperatureMinTime\": 1413025200,\n" +
            "                \"apparentTemperatureMax\": 50.97,\n" +
            "                \"apparentTemperatureMaxTime\": 1413054000,\n" +
            "                \"dewPoint\": 38.57,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 4.11,\n" +
            "                \"windBearing\": 275,\n" +
            "                \"cloudCover\": 0.39,\n" +
            "                \"pressure\": 1017.52,\n" +
            "                \"ozone\": 314.5\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"flags\": {\n" +
            "        \"sources\": [\n" +
            "            \"nwspa\",\n" +
            "            \"isd\",\n" +
            "            \"nearest-precip\",\n" +
            "            \"gfs\",\n" +
            "            \"fnmoc\",\n" +
            "            \"sref\",\n" +
            "            \"rtma\",\n" +
            "            \"rap\",\n" +
            "            \"nam\",\n" +
            "            \"cmc\",\n" +
            "            \"madis\",\n" +
            "            \"darksky\"\n" +
            "        ],\n" +
            "        \"isd-stations\": [\n" +
            "            \"711830-99999\",\n" +
            "            \"713710-99999\",\n" +
            "            \"713713-99999\",\n" +
            "            \"716120-99999\",\n" +
            "            \"716275-99999\"\n" +
            "        ],\n" +
            "        \"madis-stations\": [\n" +
            "            \"AS947\",\n" +
            "            \"AU037\",\n" +
            "            \"C3442\",\n" +
            "            \"C7533\",\n" +
            "            \"C8027\",\n" +
            "            \"C8480\",\n" +
            "            \"CWHM\",\n" +
            "            \"CWIZ\",\n" +
            "            \"CWTA\",\n" +
            "            \"CWVQ\",\n" +
            "            \"CYHU\",\n" +
            "            \"CYUL\",\n" +
            "            \"D2821\",\n" +
            "            \"D3464\",\n" +
            "            \"D8252\",\n" +
            "            \"E5418\"\n" +
            "        ],\n" +
            "        \"darksky-stations\": [\n" +
            "            \"KCXX\"\n" +
            "        ],\n" +
            "        \"units\": \"us\"\n" +
            "    }\n" +
            "}";

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


        public static String JSON_WEATHER_RAIN = "{\n" +
                "    \"latitude\": 25.671,\n" +
                "    \"longitude\": -100.31,\n" +
                "    \"timezone\": \"America/Monterrey\",\n" +
                "    \"offset\": -6,\n" +
                "    \"currently\": {\n" +
                "        \"time\": 1426579615,\n" +
                "        \"summary\": \"Rain\",\n" +
                "        \"icon\": \"rain\",\n" +
                "        \"nearestStormDistance\": 0,\n" +
                "        \"precipIntensity\": 0.0601,\n" +
                "        \"precipProbability\": 0.96,\n" +
                "        \"precipType\": \"rain\",\n" +
                "        \"temperature\": 55.84,\n" +
                "        \"apparentTemperature\": 55.84,\n" +
                "        \"dewPoint\": 54.75,\n" +
                "        \"humidity\": 0.96,\n" +
                "        \"windSpeed\": 2.37,\n" +
                "        \"windBearing\": 281,\n" +
                "        \"visibility\": 5.03,\n" +
                "        \"cloudCover\": 1,\n" +
                "        \"pressure\": 1021.47,\n" +
                "        \"ozone\": 282.94\n" +
                "    },\n" +
                "    \"hourly\": {\n" +
                "        \"summary\": \"Rain until tomorrow night.\",\n" +
                "        \"icon\": \"rain\",\n" +
                "        \"data\": [\n" +
                "            {\n" +
                "                \"time\": 1426579200,\n" +
                "                \"summary\": \"Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0591,\n" +
                "                \"precipProbability\": 0.95,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 55.85,\n" +
                "                \"apparentTemperature\": 55.85,\n" +
                "                \"dewPoint\": 54.83,\n" +
                "                \"humidity\": 0.96,\n" +
                "                \"windSpeed\": 2.27,\n" +
                "                \"windBearing\": 281,\n" +
                "                \"visibility\": 4.99,\n" +
                "                \"cloudCover\": 1,\n" +
                "                \"pressure\": 1021.61,\n" +
                "                \"ozone\": 282.87\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426582800,\n" +
                "                \"summary\": \"Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.068,\n" +
                "                \"precipProbability\": 1,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 55.8,\n" +
                "                \"apparentTemperature\": 55.8,\n" +
                "                \"dewPoint\": 54.11,\n" +
                "                \"humidity\": 0.94,\n" +
                "                \"windSpeed\": 3.12,\n" +
                "                \"windBearing\": 277,\n" +
                "                \"visibility\": 5.32,\n" +
                "                \"cloudCover\": 0.99,\n" +
                "                \"pressure\": 1020.47,\n" +
                "                \"ozone\": 283.47\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426586400,\n" +
                "                \"summary\": \"Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0578,\n" +
                "                \"precipProbability\": 0.97,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 55.62,\n" +
                "                \"apparentTemperature\": 55.62,\n" +
                "                \"dewPoint\": 53.56,\n" +
                "                \"humidity\": 0.93,\n" +
                "                \"windSpeed\": 3.18,\n" +
                "                \"windBearing\": 277,\n" +
                "                \"visibility\": 5.69,\n" +
                "                \"cloudCover\": 0.99,\n" +
                "                \"pressure\": 1020.07,\n" +
                "                \"ozone\": 284.78\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426590000,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0423,\n" +
                "                \"precipProbability\": 0.93,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 55.39,\n" +
                "                \"apparentTemperature\": 55.39,\n" +
                "                \"dewPoint\": 53.01,\n" +
                "                \"humidity\": 0.92,\n" +
                "                \"windSpeed\": 2.66,\n" +
                "                \"windBearing\": 268,\n" +
                "                \"visibility\": 6.43,\n" +
                "                \"cloudCover\": 0.98,\n" +
                "                \"pressure\": 1019.79,\n" +
                "                \"ozone\": 286.34\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426593600,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0363,\n" +
                "                \"precipProbability\": 0.89,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 55.57,\n" +
                "                \"apparentTemperature\": 55.57,\n" +
                "                \"dewPoint\": 53.15,\n" +
                "                \"humidity\": 0.92,\n" +
                "                \"windSpeed\": 1.8,\n" +
                "                \"windBearing\": 220,\n" +
                "                \"visibility\": 6.66,\n" +
                "                \"cloudCover\": 0.96,\n" +
                "                \"pressure\": 1019.76,\n" +
                "                \"ozone\": 287.57\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426597200,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0265,\n" +
                "                \"precipProbability\": 0.83,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 56.61,\n" +
                "                \"apparentTemperature\": 56.61,\n" +
                "                \"dewPoint\": 53.68,\n" +
                "                \"humidity\": 0.9,\n" +
                "                \"windSpeed\": 2.19,\n" +
                "                \"windBearing\": 177,\n" +
                "                \"visibility\": 7.04,\n" +
                "                \"cloudCover\": 0.9,\n" +
                "                \"pressure\": 1020.2,\n" +
                "                \"ozone\": 287.8\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426600800,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.019,\n" +
                "                \"precipProbability\": 0.8,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 58.35,\n" +
                "                \"apparentTemperature\": 58.35,\n" +
                "                \"dewPoint\": 54.76,\n" +
                "                \"humidity\": 0.88,\n" +
                "                \"windSpeed\": 2.91,\n" +
                "                \"windBearing\": 142,\n" +
                "                \"visibility\": 7.54,\n" +
                "                \"cloudCover\": 0.84,\n" +
                "                \"pressure\": 1020.8,\n" +
                "                \"ozone\": 287.7\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426604400,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0228,\n" +
                "                \"precipProbability\": 0.84,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 60.13,\n" +
                "                \"apparentTemperature\": 60.13,\n" +
                "                \"dewPoint\": 56.3,\n" +
                "                \"humidity\": 0.87,\n" +
                "                \"windSpeed\": 4.03,\n" +
                "                \"windBearing\": 136,\n" +
                "                \"visibility\": 7.71,\n" +
                "                \"cloudCover\": 0.81,\n" +
                "                \"pressure\": 1021.18,\n" +
                "                \"ozone\": 288.73\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426608000,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0204,\n" +
                "                \"precipProbability\": 0.82,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 61.13,\n" +
                "                \"apparentTemperature\": 61.13,\n" +
                "                \"dewPoint\": 56.91,\n" +
                "                \"humidity\": 0.86,\n" +
                "                \"windSpeed\": 4.31,\n" +
                "                \"windBearing\": 130,\n" +
                "                \"visibility\": 7.78,\n" +
                "                \"cloudCover\": 0.85,\n" +
                "                \"pressure\": 1021.11,\n" +
                "                \"ozone\": 292.29\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426611600,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0234,\n" +
                "                \"precipProbability\": 0.83,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 62.39,\n" +
                "                \"apparentTemperature\": 62.39,\n" +
                "                \"dewPoint\": 57.75,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 5.37,\n" +
                "                \"windBearing\": 119,\n" +
                "                \"visibility\": 7.78,\n" +
                "                \"cloudCover\": 0.93,\n" +
                "                \"pressure\": 1020.76,\n" +
                "                \"ozone\": 296.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426615200,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0419,\n" +
                "                \"precipProbability\": 0.85,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 62.33,\n" +
                "                \"apparentTemperature\": 62.33,\n" +
                "                \"dewPoint\": 57.72,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 5.47,\n" +
                "                \"windBearing\": 118,\n" +
                "                \"visibility\": 7.49,\n" +
                "                \"cloudCover\": 0.98,\n" +
                "                \"pressure\": 1020.17,\n" +
                "                \"ozone\": 300.15\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426618800,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0257,\n" +
                "                \"precipProbability\": 0.85,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 63.58,\n" +
                "                \"apparentTemperature\": 63.58,\n" +
                "                \"dewPoint\": 58.54,\n" +
                "                \"humidity\": 0.84,\n" +
                "                \"windSpeed\": 6.03,\n" +
                "                \"windBearing\": 111,\n" +
                "                \"visibility\": 7.71,\n" +
                "                \"cloudCover\": 0.98,\n" +
                "                \"pressure\": 1019.18,\n" +
                "                \"ozone\": 300.56\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426622400,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0209,\n" +
                "                \"precipProbability\": 0.85,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 64.97,\n" +
                "                \"apparentTemperature\": 64.97,\n" +
                "                \"dewPoint\": 59.05,\n" +
                "                \"humidity\": 0.81,\n" +
                "                \"windSpeed\": 6.82,\n" +
                "                \"windBearing\": 107,\n" +
                "                \"visibility\": 7.93,\n" +
                "                \"cloudCover\": 0.95,\n" +
                "                \"pressure\": 1017.96,\n" +
                "                \"ozone\": 299.43\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426626000,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0174,\n" +
                "                \"precipProbability\": 0.77,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 65.72,\n" +
                "                \"apparentTemperature\": 65.72,\n" +
                "                \"dewPoint\": 59.58,\n" +
                "                \"humidity\": 0.81,\n" +
                "                \"windSpeed\": 7.43,\n" +
                "                \"windBearing\": 107,\n" +
                "                \"visibility\": 8.22,\n" +
                "                \"cloudCover\": 0.93,\n" +
                "                \"pressure\": 1017.01,\n" +
                "                \"ozone\": 297.7\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426629600,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0205,\n" +
                "                \"precipProbability\": 0.83,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 64.88,\n" +
                "                \"apparentTemperature\": 64.88,\n" +
                "                \"dewPoint\": 59.37,\n" +
                "                \"humidity\": 0.82,\n" +
                "                \"windSpeed\": 7.87,\n" +
                "                \"windBearing\": 113,\n" +
                "                \"visibility\": 7.67,\n" +
                "                \"cloudCover\": 0.93,\n" +
                "                \"pressure\": 1016.52,\n" +
                "                \"ozone\": 295.31\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426633200,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0248,\n" +
                "                \"precipProbability\": 0.81,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 63.85,\n" +
                "                \"apparentTemperature\": 63.85,\n" +
                "                \"dewPoint\": 59.2,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 7.92,\n" +
                "                \"windBearing\": 117,\n" +
                "                \"visibility\": 7.34,\n" +
                "                \"cloudCover\": 0.92,\n" +
                "                \"pressure\": 1016.3,\n" +
                "                \"ozone\": 292.32\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426636800,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0285,\n" +
                "                \"precipProbability\": 0.78,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 62.78,\n" +
                "                \"apparentTemperature\": 62.78,\n" +
                "                \"dewPoint\": 59.1,\n" +
                "                \"humidity\": 0.88,\n" +
                "                \"windSpeed\": 7.64,\n" +
                "                \"windBearing\": 117,\n" +
                "                \"visibility\": 7.05,\n" +
                "                \"cloudCover\": 0.9,\n" +
                "                \"pressure\": 1016.28,\n" +
                "                \"ozone\": 289.92\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426640400,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0232,\n" +
                "                \"precipProbability\": 0.63,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 62.35,\n" +
                "                \"apparentTemperature\": 62.35,\n" +
                "                \"dewPoint\": 59.26,\n" +
                "                \"humidity\": 0.9,\n" +
                "                \"windSpeed\": 7.07,\n" +
                "                \"windBearing\": 120,\n" +
                "                \"visibility\": 7.67,\n" +
                "                \"cloudCover\": 0.88,\n" +
                "                \"pressure\": 1016.55,\n" +
                "                \"ozone\": 288.63\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426644000,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0161,\n" +
                "                \"precipProbability\": 0.44,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 61.87,\n" +
                "                \"apparentTemperature\": 61.87,\n" +
                "                \"dewPoint\": 59.43,\n" +
                "                \"humidity\": 0.92,\n" +
                "                \"windSpeed\": 6.65,\n" +
                "                \"windBearing\": 123,\n" +
                "                \"visibility\": 8.52,\n" +
                "                \"cloudCover\": 0.86,\n" +
                "                \"pressure\": 1017.05,\n" +
                "                \"ozone\": 287.93\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426647600,\n" +
                "                \"summary\": \"Light Rain\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0104,\n" +
                "                \"precipProbability\": 0.31,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 61.29,\n" +
                "                \"apparentTemperature\": 61.29,\n" +
                "                \"dewPoint\": 59.35,\n" +
                "                \"humidity\": 0.93,\n" +
                "                \"windSpeed\": 6.24,\n" +
                "                \"windBearing\": 126,\n" +
                "                \"visibility\": 9.27,\n" +
                "                \"cloudCover\": 0.8,\n" +
                "                \"pressure\": 1017.45,\n" +
                "                \"ozone\": 287.4\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426651200,\n" +
                "                \"summary\": \"Drizzle\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.008,\n" +
                "                \"precipProbability\": 0.22,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 60.55,\n" +
                "                \"apparentTemperature\": 60.55,\n" +
                "                \"dewPoint\": 58.82,\n" +
                "                \"humidity\": 0.94,\n" +
                "                \"windSpeed\": 5.92,\n" +
                "                \"windBearing\": 127,\n" +
                "                \"visibility\": 9.67,\n" +
                "                \"cloudCover\": 0.71,\n" +
                "                \"pressure\": 1017.71,\n" +
                "                \"ozone\": 286.98\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426654800,\n" +
                "                \"summary\": \"Drizzle\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0066,\n" +
                "                \"precipProbability\": 0.15,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 59.8,\n" +
                "                \"apparentTemperature\": 59.8,\n" +
                "                \"dewPoint\": 58.11,\n" +
                "                \"humidity\": 0.94,\n" +
                "                \"windSpeed\": 5.14,\n" +
                "                \"windBearing\": 131,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.6,\n" +
                "                \"pressure\": 1017.87,\n" +
                "                \"ozone\": 286.74\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426658400,\n" +
                "                \"summary\": \"Drizzle\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"precipIntensity\": 0.0063,\n" +
                "                \"precipProbability\": 0.15,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 59.49,\n" +
                "                \"apparentTemperature\": 59.49,\n" +
                "                \"dewPoint\": 57.71,\n" +
                "                \"humidity\": 0.94,\n" +
                "                \"windSpeed\": 4.68,\n" +
                "                \"windBearing\": 132,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.56,\n" +
                "                \"pressure\": 1017.8,\n" +
                "                \"ozone\": 286.41\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426662000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0.0049,\n" +
                "                \"precipProbability\": 0.09,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 59.32,\n" +
                "                \"apparentTemperature\": 59.32,\n" +
                "                \"dewPoint\": 57.48,\n" +
                "                \"humidity\": 0.94,\n" +
                "                \"windSpeed\": 3.99,\n" +
                "                \"windBearing\": 136,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.61,\n" +
                "                \"pressure\": 1017.34,\n" +
                "                \"ozone\": 285.86\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426665600,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0.003,\n" +
                "                \"precipProbability\": 0.02,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 59.27,\n" +
                "                \"apparentTemperature\": 59.27,\n" +
                "                \"dewPoint\": 57.32,\n" +
                "                \"humidity\": 0.93,\n" +
                "                \"windSpeed\": 3.26,\n" +
                "                \"windBearing\": 141,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.71,\n" +
                "                \"pressure\": 1016.67,\n" +
                "                \"ozone\": 285.22\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426669200,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 59.23,\n" +
                "                \"apparentTemperature\": 59.23,\n" +
                "                \"dewPoint\": 57.16,\n" +
                "                \"humidity\": 0.93,\n" +
                "                \"windSpeed\": 2.66,\n" +
                "                \"windBearing\": 148,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.77,\n" +
                "                \"pressure\": 1016.14,\n" +
                "                \"ozone\": 284.66\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426672800,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 59.06,\n" +
                "                \"apparentTemperature\": 59.06,\n" +
                "                \"dewPoint\": 56.88,\n" +
                "                \"humidity\": 0.92,\n" +
                "                \"windSpeed\": 2.24,\n" +
                "                \"windBearing\": 156,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.74,\n" +
                "                \"pressure\": 1015.9,\n" +
                "                \"ozone\": 284.18\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426676400,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 58.93,\n" +
                "                \"apparentTemperature\": 58.93,\n" +
                "                \"dewPoint\": 56.6,\n" +
                "                \"humidity\": 0.92,\n" +
                "                \"windSpeed\": 1.96,\n" +
                "                \"windBearing\": 165,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.66,\n" +
                "                \"pressure\": 1015.83,\n" +
                "                \"ozone\": 283.78\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426680000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 59.22,\n" +
                "                \"apparentTemperature\": 59.22,\n" +
                "                \"dewPoint\": 56.59,\n" +
                "                \"humidity\": 0.91,\n" +
                "                \"windSpeed\": 1.69,\n" +
                "                \"windBearing\": 169,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.62,\n" +
                "                \"pressure\": 1015.94,\n" +
                "                \"ozone\": 283.54\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426683600,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 60.12,\n" +
                "                \"apparentTemperature\": 60.12,\n" +
                "                \"dewPoint\": 56.98,\n" +
                "                \"humidity\": 0.89,\n" +
                "                \"windSpeed\": 1.23,\n" +
                "                \"windBearing\": 161,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.64,\n" +
                "                \"pressure\": 1016.39,\n" +
                "                \"ozone\": 283.52\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426687200,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 61.53,\n" +
                "                \"apparentTemperature\": 61.53,\n" +
                "                \"dewPoint\": 57.68,\n" +
                "                \"humidity\": 0.87,\n" +
                "                \"windSpeed\": 0.74,\n" +
                "                \"windBearing\": 124,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.69,\n" +
                "                \"pressure\": 1017.01,\n" +
                "                \"ozone\": 283.66\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426690800,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 63.35,\n" +
                "                \"apparentTemperature\": 63.35,\n" +
                "                \"dewPoint\": 58.52,\n" +
                "                \"humidity\": 0.84,\n" +
                "                \"windSpeed\": 1.01,\n" +
                "                \"windBearing\": 92,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.74,\n" +
                "                \"pressure\": 1017.32,\n" +
                "                \"ozone\": 283.94\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426694400,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 65.67,\n" +
                "                \"apparentTemperature\": 65.67,\n" +
                "                \"dewPoint\": 59.4,\n" +
                "                \"humidity\": 0.8,\n" +
                "                \"windSpeed\": 1.69,\n" +
                "                \"windBearing\": 88,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.77,\n" +
                "                \"pressure\": 1017.09,\n" +
                "                \"ozone\": 284.51\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426698000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0016,\n" +
                "                \"precipProbability\": 0.01,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 68.24,\n" +
                "                \"apparentTemperature\": 68.24,\n" +
                "                \"dewPoint\": 60.17,\n" +
                "                \"humidity\": 0.75,\n" +
                "                \"windSpeed\": 2.56,\n" +
                "                \"windBearing\": 93,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.8,\n" +
                "                \"pressure\": 1016.56,\n" +
                "                \"ozone\": 285.21\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426701600,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0021,\n" +
                "                \"precipProbability\": 0.03,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 70.37,\n" +
                "                \"apparentTemperature\": 70.37,\n" +
                "                \"dewPoint\": 60.68,\n" +
                "                \"humidity\": 0.71,\n" +
                "                \"windSpeed\": 3.39,\n" +
                "                \"windBearing\": 97,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.8,\n" +
                "                \"pressure\": 1015.88,\n" +
                "                \"ozone\": 285.55\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426705200,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0025,\n" +
                "                \"precipProbability\": 0.03,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 71.96,\n" +
                "                \"apparentTemperature\": 71.96,\n" +
                "                \"dewPoint\": 60.93,\n" +
                "                \"humidity\": 0.68,\n" +
                "                \"windSpeed\": 4.07,\n" +
                "                \"windBearing\": 99,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.77,\n" +
                "                \"pressure\": 1014.97,\n" +
                "                \"ozone\": 285.24\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426708800,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0027,\n" +
                "                \"precipProbability\": 0.04,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 73.19,\n" +
                "                \"apparentTemperature\": 73.19,\n" +
                "                \"dewPoint\": 61.06,\n" +
                "                \"humidity\": 0.66,\n" +
                "                \"windSpeed\": 4.69,\n" +
                "                \"windBearing\": 101,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.71,\n" +
                "                \"pressure\": 1013.91,\n" +
                "                \"ozone\": 284.57\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426712400,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0027,\n" +
                "                \"precipProbability\": 0.04,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 73.8,\n" +
                "                \"apparentTemperature\": 73.8,\n" +
                "                \"dewPoint\": 61.21,\n" +
                "                \"humidity\": 0.65,\n" +
                "                \"windSpeed\": 5.22,\n" +
                "                \"windBearing\": 104,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.69,\n" +
                "                \"pressure\": 1013.08,\n" +
                "                \"ozone\": 283.86\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426716000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0026,\n" +
                "                \"precipProbability\": 0.03,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 73.57,\n" +
                "                \"apparentTemperature\": 73.57,\n" +
                "                \"dewPoint\": 61.44,\n" +
                "                \"humidity\": 0.66,\n" +
                "                \"windSpeed\": 5.78,\n" +
                "                \"windBearing\": 108,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.74,\n" +
                "                \"pressure\": 1012.58,\n" +
                "                \"ozone\": 283.13\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426719600,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0022,\n" +
                "                \"precipProbability\": 0.03,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 72.72,\n" +
                "                \"apparentTemperature\": 72.72,\n" +
                "                \"dewPoint\": 61.69,\n" +
                "                \"humidity\": 0.68,\n" +
                "                \"windSpeed\": 6.33,\n" +
                "                \"windBearing\": 112,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.81,\n" +
                "                \"pressure\": 1012.29,\n" +
                "                \"ozone\": 282.38\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426723200,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"precipIntensity\": 0.0018,\n" +
                "                \"precipProbability\": 0.02,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 71.5,\n" +
                "                \"apparentTemperature\": 71.5,\n" +
                "                \"dewPoint\": 61.86,\n" +
                "                \"humidity\": 0.72,\n" +
                "                \"windSpeed\": 6.59,\n" +
                "                \"windBearing\": 116,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.85,\n" +
                "                \"pressure\": 1012.28,\n" +
                "                \"ozone\": 281.84\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426726800,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0.0012,\n" +
                "                \"precipProbability\": 0.01,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperature\": 69.7,\n" +
                "                \"apparentTemperature\": 69.7,\n" +
                "                \"dewPoint\": 61.92,\n" +
                "                \"humidity\": 0.76,\n" +
                "                \"windSpeed\": 6.15,\n" +
                "                \"windBearing\": 122,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.81,\n" +
                "                \"pressure\": 1012.72,\n" +
                "                \"ozone\": 281.66\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426730400,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 67.49,\n" +
                "                \"apparentTemperature\": 67.49,\n" +
                "                \"dewPoint\": 61.77,\n" +
                "                \"humidity\": 0.82,\n" +
                "                \"windSpeed\": 5.46,\n" +
                "                \"windBearing\": 133,\n" +
                "                \"visibility\": 9.99,\n" +
                "                \"cloudCover\": 0.74,\n" +
                "                \"pressure\": 1013.47,\n" +
                "                \"ozone\": 281.7\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426734000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 65.61,\n" +
                "                \"apparentTemperature\": 65.61,\n" +
                "                \"dewPoint\": 61.27,\n" +
                "                \"humidity\": 0.86,\n" +
                "                \"windSpeed\": 4.96,\n" +
                "                \"windBearing\": 143,\n" +
                "                \"visibility\": 9.99,\n" +
                "                \"cloudCover\": 0.7,\n" +
                "                \"pressure\": 1014.09,\n" +
                "                \"ozone\": 281.82\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426737600,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 64.43,\n" +
                "                \"apparentTemperature\": 64.43,\n" +
                "                \"dewPoint\": 60.41,\n" +
                "                \"humidity\": 0.87,\n" +
                "                \"windSpeed\": 4.68,\n" +
                "                \"windBearing\": 148,\n" +
                "                \"visibility\": 9.99,\n" +
                "                \"cloudCover\": 0.72,\n" +
                "                \"pressure\": 1014.35,\n" +
                "                \"ozone\": 282.06\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426741200,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 63.75,\n" +
                "                \"apparentTemperature\": 63.75,\n" +
                "                \"dewPoint\": 59.47,\n" +
                "                \"humidity\": 0.86,\n" +
                "                \"windSpeed\": 4.4,\n" +
                "                \"windBearing\": 150,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.76,\n" +
                "                \"pressure\": 1014.4,\n" +
                "                \"ozone\": 282.39\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426744800,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 63.24,\n" +
                "                \"apparentTemperature\": 63.24,\n" +
                "                \"dewPoint\": 58.72,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 4.1,\n" +
                "                \"windBearing\": 152,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.78,\n" +
                "                \"pressure\": 1014.27,\n" +
                "                \"ozone\": 282.52\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426748400,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 62.56,\n" +
                "                \"apparentTemperature\": 62.56,\n" +
                "                \"dewPoint\": 58.04,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 3.72,\n" +
                "                \"windBearing\": 155,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.77,\n" +
                "                \"pressure\": 1013.88,\n" +
                "                \"ozone\": 282.27\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426752000,\n" +
                "                \"summary\": \"Mostly Cloudy\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperature\": 61.86,\n" +
                "                \"apparentTemperature\": 61.86,\n" +
                "                \"dewPoint\": 57.37,\n" +
                "                \"humidity\": 0.85,\n" +
                "                \"windSpeed\": 3.34,\n" +
                "                \"windBearing\": 158,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.75,\n" +
                "                \"pressure\": 1013.36,\n" +
                "                \"ozone\": 281.81\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"daily\": {\n" +
                "        \"summary\": \"Light rain throughout the week, with temperatures rising " +
                "to 80°F on Monday.\",\n" +
                "        \"icon\": \"rain\",\n" +
                "        \"data\": [\n" +
                "            {\n" +
                "                \"time\": 1426572000,\n" +
                "                \"summary\": \"Rain throughout the day.\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"sunriseTime\": 1426596592,\n" +
                "                \"sunsetTime\": 1426639922,\n" +
                "                \"moonPhase\": 0.9,\n" +
                "                \"precipIntensity\": 0.0293,\n" +
                "                \"precipIntensityMax\": 0.068,\n" +
                "                \"precipIntensityMaxTime\": 1426582800,\n" +
                "                \"precipProbability\": 1,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 55.39,\n" +
                "                \"temperatureMinTime\": 1426590000,\n" +
                "                \"temperatureMax\": 65.72,\n" +
                "                \"temperatureMaxTime\": 1426626000,\n" +
                "                \"apparentTemperatureMin\": 55.39,\n" +
                "                \"apparentTemperatureMinTime\": 1426590000,\n" +
                "                \"apparentTemperatureMax\": 65.72,\n" +
                "                \"apparentTemperatureMaxTime\": 1426626000,\n" +
                "                \"dewPoint\": 57.09,\n" +
                "                \"humidity\": 0.89,\n" +
                "                \"windSpeed\": 3.47,\n" +
                "                \"windBearing\": 124,\n" +
                "                \"visibility\": 7.15,\n" +
                "                \"cloudCover\": 0.9,\n" +
                "                \"pressure\": 1019.14,\n" +
                "                \"ozone\": 289.82\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426658400,\n" +
                "                \"summary\": \"Mostly cloudy throughout the day.\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"sunriseTime\": 1426682929,\n" +
                "                \"sunsetTime\": 1426726350,\n" +
                "                \"moonPhase\": 0.94,\n" +
                "                \"precipIntensity\": 0.0017,\n" +
                "                \"precipIntensityMax\": 0.0063,\n" +
                "                \"precipIntensityMaxTime\": 1426658400,\n" +
                "                \"precipProbability\": 0.15,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 58.93,\n" +
                "                \"temperatureMinTime\": 1426676400,\n" +
                "                \"temperatureMax\": 73.8,\n" +
                "                \"temperatureMaxTime\": 1426712400,\n" +
                "                \"apparentTemperatureMin\": 58.93,\n" +
                "                \"apparentTemperatureMinTime\": 1426676400,\n" +
                "                \"apparentTemperatureMax\": 73.8,\n" +
                "                \"apparentTemperatureMaxTime\": 1426712400,\n" +
                "                \"dewPoint\": 59.42,\n" +
                "                \"humidity\": 0.82,\n" +
                "                \"windSpeed\": 3.48,\n" +
                "                \"windBearing\": 124,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.73,\n" +
                "                \"pressure\": 1015.17,\n" +
                "                \"ozone\": 283.78\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426744800,\n" +
                "                \"summary\": \"Mostly cloudy throughout the day.\",\n" +
                "                \"icon\": \"partly-cloudy-day\",\n" +
                "                \"sunriseTime\": 1426769265,\n" +
                "                \"sunsetTime\": 1426812777,\n" +
                "                \"moonPhase\": 0.98,\n" +
                "                \"precipIntensity\": 0.0012,\n" +
                "                \"precipIntensityMax\": 0.0057,\n" +
                "                \"precipIntensityMaxTime\": 1426798800,\n" +
                "                \"precipProbability\": 0.09,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 60.42,\n" +
                "                \"temperatureMinTime\": 1426762800,\n" +
                "                \"temperatureMax\": 78.44,\n" +
                "                \"temperatureMaxTime\": 1426802400,\n" +
                "                \"apparentTemperatureMin\": 60.42,\n" +
                "                \"apparentTemperatureMinTime\": 1426762800,\n" +
                "                \"apparentTemperatureMax\": 78.44,\n" +
                "                \"apparentTemperatureMaxTime\": 1426802400,\n" +
                "                \"dewPoint\": 60.29,\n" +
                "                \"humidity\": 0.74,\n" +
                "                \"windSpeed\": 3.73,\n" +
                "                \"windBearing\": 122,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.6,\n" +
                "                \"pressure\": 1012.32,\n" +
                "                \"ozone\": 278.09\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426831200,\n" +
                "                \"summary\": \"Rain starting in the afternoon.\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"sunriseTime\": 1426855601,\n" +
                "                \"sunsetTime\": 1426899204,\n" +
                "                \"moonPhase\": 0.02,\n" +
                "                \"precipIntensity\": 0.0118,\n" +
                "                \"precipIntensityMax\": 0.0345,\n" +
                "                \"precipIntensityMaxTime\": 1426914000,\n" +
                "                \"precipProbability\": 1,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 64.99,\n" +
                "                \"temperatureMinTime\": 1426849200,\n" +
                "                \"temperatureMax\": 77.39,\n" +
                "                \"temperatureMaxTime\": 1426881600,\n" +
                "                \"apparentTemperatureMin\": 64.99,\n" +
                "                \"apparentTemperatureMinTime\": 1426849200,\n" +
                "                \"apparentTemperatureMax\": 77.39,\n" +
                "                \"apparentTemperatureMaxTime\": 1426881600,\n" +
                "                \"dewPoint\": 62.55,\n" +
                "                \"humidity\": 0.77,\n" +
                "                \"windSpeed\": 1.9,\n" +
                "                \"windBearing\": 121,\n" +
                "                \"visibility\": 10,\n" +
                "                \"cloudCover\": 0.96,\n" +
                "                \"pressure\": 1013.41,\n" +
                "                \"ozone\": 268.71\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1426917600,\n" +
                "                \"summary\": \"Rain until evening.\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"sunriseTime\": 1426941936,\n" +
                "                \"sunsetTime\": 1426985631,\n" +
                "                \"moonPhase\": 0.05,\n" +
                "                \"precipIntensity\": 0.0388,\n" +
                "                \"precipIntensityMax\": 0.0601,\n" +
                "                \"precipIntensityMaxTime\": 1426946400,\n" +
                "                \"precipProbability\": 1,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 64.01,\n" +
                "                \"temperatureMinTime\": 1426935600,\n" +
                "                \"temperatureMax\": 75.96,\n" +
                "                \"temperatureMaxTime\": 1426971600,\n" +
                "                \"apparentTemperatureMin\": 64.01,\n" +
                "                \"apparentTemperatureMinTime\": 1426935600,\n" +
                "                \"apparentTemperatureMax\": 75.96,\n" +
                "                \"apparentTemperatureMaxTime\": 1426971600,\n" +
                "                \"dewPoint\": 62.08,\n" +
                "                \"humidity\": 0.8,\n" +
                "                \"windSpeed\": 0.58,\n" +
                "                \"windBearing\": 79,\n" +
                "                \"cloudCover\": 0.45,\n" +
                "                \"pressure\": 1014.83,\n" +
                "                \"ozone\": 270.31\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1427004000,\n" +
                "                \"summary\": \"Mostly cloudy in the morning.\",\n" +
                "                \"icon\": \"partly-cloudy-night\",\n" +
                "                \"sunriseTime\": 1427028272,\n" +
                "                \"sunsetTime\": 1427072058,\n" +
                "                \"moonPhase\": 0.09,\n" +
                "                \"precipIntensity\": 0.0009,\n" +
                "                \"precipIntensityMax\": 0.0025,\n" +
                "                \"precipIntensityMaxTime\": 1427058000,\n" +
                "                \"precipProbability\": 0.03,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 59.39,\n" +
                "                \"temperatureMinTime\": 1427022000,\n" +
                "                \"temperatureMax\": 77.18,\n" +
                "                \"temperatureMaxTime\": 1427058000,\n" +
                "                \"apparentTemperatureMin\": 59.39,\n" +
                "                \"apparentTemperatureMinTime\": 1427022000,\n" +
                "                \"apparentTemperatureMax\": 77.18,\n" +
                "                \"apparentTemperatureMaxTime\": 1427058000,\n" +
                "                \"dewPoint\": 59.7,\n" +
                "                \"humidity\": 0.77,\n" +
                "                \"windSpeed\": 1.45,\n" +
                "                \"windBearing\": 59,\n" +
                "                \"cloudCover\": 0.28,\n" +
                "                \"pressure\": 1016.73,\n" +
                "                \"ozone\": 268.66\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1427090400,\n" +
                "                \"summary\": \"Clear throughout the day.\",\n" +
                "                \"icon\": \"clear-day\",\n" +
                "                \"sunriseTime\": 1427114608,\n" +
                "                \"sunsetTime\": 1427158484,\n" +
                "                \"moonPhase\": 0.13,\n" +
                "                \"precipIntensity\": 0,\n" +
                "                \"precipIntensityMax\": 0,\n" +
                "                \"precipProbability\": 0,\n" +
                "                \"temperatureMin\": 58.36,\n" +
                "                \"temperatureMinTime\": 1427108400,\n" +
                "                \"temperatureMax\": 80.14,\n" +
                "                \"temperatureMaxTime\": 1427144400,\n" +
                "                \"apparentTemperatureMin\": 58.36,\n" +
                "                \"apparentTemperatureMinTime\": 1427108400,\n" +
                "                \"apparentTemperatureMax\": 80.31,\n" +
                "                \"apparentTemperatureMaxTime\": 1427144400,\n" +
                "                \"dewPoint\": 56.33,\n" +
                "                \"humidity\": 0.67,\n" +
                "                \"windSpeed\": 1.44,\n" +
                "                \"windBearing\": 69,\n" +
                "                \"cloudCover\": 0,\n" +
                "                \"pressure\": 1017.03,\n" +
                "                \"ozone\": 271.03\n" +
                "            },\n" +
                "            {\n" +
                "                \"time\": 1427176800,\n" +
                "                \"summary\": \"Light rain until afternoon.\",\n" +
                "                \"icon\": \"rain\",\n" +
                "                \"sunriseTime\": 1427200943,\n" +
                "                \"sunsetTime\": 1427244911,\n" +
                "                \"moonPhase\": 0.16,\n" +
                "                \"precipIntensity\": 0.003,\n" +
                "                \"precipIntensityMax\": 0.0103,\n" +
                "                \"precipIntensityMaxTime\": 1427209200,\n" +
                "                \"precipProbability\": 0.7,\n" +
                "                \"precipType\": \"rain\",\n" +
                "                \"temperatureMin\": 59.44,\n" +
                "                \"temperatureMinTime\": 1427191200,\n" +
                "                \"temperatureMax\": 69.47,\n" +
                "                \"temperatureMaxTime\": 1427230800,\n" +
                "                \"apparentTemperatureMin\": 59.44,\n" +
                "                \"apparentTemperatureMinTime\": 1427191200,\n" +
                "                \"apparentTemperatureMax\": 69.47,\n" +
                "                \"apparentTemperatureMaxTime\": 1427230800,\n" +
                "                \"dewPoint\": 57.55,\n" +
                "                \"humidity\": 0.81,\n" +
                "                \"windSpeed\": 5.09,\n" +
                "                \"windBearing\": 78,\n" +
                "                \"cloudCover\": 0.53,\n" +
                "                \"pressure\": 1022.73,\n" +
                "                \"ozone\": 272.78\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"flags\": {\n" +
                "        \"sources\": [\n" +
                "            \"nwspa\",\n" +
                "            \"isd\",\n" +
                "            \"nearest-precip\",\n" +
                "            \"fnmoc\",\n" +
                "            \"sref\",\n" +
                "            \"rtma\",\n" +
                "            \"rap\",\n" +
                "            \"nam\",\n" +
                "            \"cmc\",\n" +
                "            \"gfs\",\n" +
                "            \"madis\"\n" +
                "        ],\n" +
                "        \"isd-stations\": [\n" +
                "            \"763900-99999\",\n" +
                "            \"763930-99999\",\n" +
                "            \"763940-99999\",\n" +
                "            \"763943-99999\",\n" +
                "            \"763944-99999\"\n" +
                "        ],\n" +
                "        \"madis-stations\": [\n" +
                "            \"D0029\",\n" +
                "            \"D9577\",\n" +
                "            \"MMAN\",\n" +
                "            \"MMMY\"\n" +
                "        ],\n" +
                "        \"units\": \"us\"\n" +
                "    }\n" +
                "}";
}
