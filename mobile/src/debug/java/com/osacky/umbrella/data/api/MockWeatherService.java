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
        return Observable.just(mGson.fromJson(JSON_MONTREAL, WeatherResult.class));
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

    private static final String JSON_MEDIUM_RAIN = "{\n" +
            "    \"latitude\": 28.8072,\n" +
            "    \"longitude\": -82.55,\n" +
            "    \"timezone\": \"America/New_York\",\n" +
            "    \"offset\": -4,\n" +
            "    \"currently\": {\n" +
            "        \"time\": 1411948233,\n" +
            "        \"summary\": \"Light Rain\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"nearestStormDistance\": 0,\n" +
            "        \"precipIntensity\": 0.0531,\n" +
            "        \"precipIntensityError\": 0.0022,\n" +
            "        \"precipProbability\": 1,\n" +
            "        \"precipType\": \"rain\",\n" +
            "        \"temperature\": 74.93,\n" +
            "        \"apparentTemperature\": 74.93,\n" +
            "        \"dewPoint\": 71.95,\n" +
            "        \"humidity\": 0.9,\n" +
            "        \"windSpeed\": 1.86,\n" +
            "        \"windBearing\": 59,\n" +
            "        \"visibility\": 3.15,\n" +
            "        \"cloudCover\": 1,\n" +
            "        \"pressure\": 1014.62,\n" +
            "        \"ozone\": 279.48\n" +
            "    },\n" +
            "    \"minutely\": {\n" +
            "        \"summary\": \"Rain for the hour.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411948200,\n" +
            "                \"precipIntensity\": 0.0516,\n" +
            "                \"precipIntensityError\": 0.002,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948260,\n" +
            "                \"precipIntensity\": 0.0543,\n" +
            "                \"precipIntensityError\": 0.0024,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948320,\n" +
            "                \"precipIntensity\": 0.0586,\n" +
            "                \"precipIntensityError\": 0.0029,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948380,\n" +
            "                \"precipIntensity\": 0.0593,\n" +
            "                \"precipIntensityError\": 0.0032,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948440,\n" +
            "                \"precipIntensity\": 0.0632,\n" +
            "                \"precipIntensityError\": 0.0035,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948500,\n" +
            "                \"precipIntensity\": 0.0718,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948560,\n" +
            "                \"precipIntensity\": 0.0757,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948620,\n" +
            "                \"precipIntensity\": 0.08,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948680,\n" +
            "                \"precipIntensity\": 0.0793,\n" +
            "                \"precipIntensityError\": 0.0041,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948740,\n" +
            "                \"precipIntensity\": 0.0823,\n" +
            "                \"precipIntensityError\": 0.0041,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948800,\n" +
            "                \"precipIntensity\": 0.0847,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948860,\n" +
            "                \"precipIntensity\": 0.0833,\n" +
            "                \"precipIntensityError\": 0.0041,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948920,\n" +
            "                \"precipIntensity\": 0.085,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948980,\n" +
            "                \"precipIntensity\": 0.0859,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949040,\n" +
            "                \"precipIntensity\": 0.0848,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949100,\n" +
            "                \"precipIntensity\": 0.0853,\n" +
            "                \"precipIntensityError\": 0.0035,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949160,\n" +
            "                \"precipIntensity\": 0.0844,\n" +
            "                \"precipIntensityError\": 0.0035,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949220,\n" +
            "                \"precipIntensity\": 0.0829,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949280,\n" +
            "                \"precipIntensity\": 0.0818,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949340,\n" +
            "                \"precipIntensity\": 0.0802,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949400,\n" +
            "                \"precipIntensity\": 0.0796,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949460,\n" +
            "                \"precipIntensity\": 0.0772,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949520,\n" +
            "                \"precipIntensity\": 0.0768,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949580,\n" +
            "                \"precipIntensity\": 0.0752,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949640,\n" +
            "                \"precipIntensity\": 0.0742,\n" +
            "                \"precipIntensityError\": 0.0039,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949700,\n" +
            "                \"precipIntensity\": 0.0731,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949760,\n" +
            "                \"precipIntensity\": 0.0722,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949820,\n" +
            "                \"precipIntensity\": 0.0705,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949880,\n" +
            "                \"precipIntensity\": 0.0703,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949940,\n" +
            "                \"precipIntensity\": 0.0697,\n" +
            "                \"precipIntensityError\": 0.0036,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950000,\n" +
            "                \"precipIntensity\": 0.0691,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950060,\n" +
            "                \"precipIntensity\": 0.0685,\n" +
            "                \"precipIntensityError\": 0.0037,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950120,\n" +
            "                \"precipIntensity\": 0.0686,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950180,\n" +
            "                \"precipIntensity\": 0.068,\n" +
            "                \"precipIntensityError\": 0.0038,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950240,\n" +
            "                \"precipIntensity\": 0.0685,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950300,\n" +
            "                \"precipIntensity\": 0.0686,\n" +
            "                \"precipIntensityError\": 0.0042,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950360,\n" +
            "                \"precipIntensity\": 0.0683,\n" +
            "                \"precipIntensityError\": 0.0042,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950420,\n" +
            "                \"precipIntensity\": 0.0693,\n" +
            "                \"precipIntensityError\": 0.0047,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950480,\n" +
            "                \"precipIntensity\": 0.0695,\n" +
            "                \"precipIntensityError\": 0.0048,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950540,\n" +
            "                \"precipIntensity\": 0.0697,\n" +
            "                \"precipIntensityError\": 0.005,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950600,\n" +
            "                \"precipIntensity\": 0.07,\n" +
            "                \"precipIntensityError\": 0.0053,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950660,\n" +
            "                \"precipIntensity\": 0.0711,\n" +
            "                \"precipIntensityError\": 0.0057,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950720,\n" +
            "                \"precipIntensity\": 0.0716,\n" +
            "                \"precipIntensityError\": 0.0059,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950780,\n" +
            "                \"precipIntensity\": 0.0722,\n" +
            "                \"precipIntensityError\": 0.0065,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950840,\n" +
            "                \"precipIntensity\": 0.0738,\n" +
            "                \"precipIntensityError\": 0.0071,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950900,\n" +
            "                \"precipIntensity\": 0.075,\n" +
            "                \"precipIntensityError\": 0.0074,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950960,\n" +
            "                \"precipIntensity\": 0.075,\n" +
            "                \"precipIntensityError\": 0.0076,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951020,\n" +
            "                \"precipIntensity\": 0.079,\n" +
            "                \"precipIntensityError\": 0.0089,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951080,\n" +
            "                \"precipIntensity\": 0.0794,\n" +
            "                \"precipIntensityError\": 0.0092,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951140,\n" +
            "                \"precipIntensity\": 0.08,\n" +
            "                \"precipIntensityError\": 0.0095,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951200,\n" +
            "                \"precipIntensity\": 0.0811,\n" +
            "                \"precipIntensityError\": 0.01,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951260,\n" +
            "                \"precipIntensity\": 0.0832,\n" +
            "                \"precipIntensityError\": 0.0104,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951320,\n" +
            "                \"precipIntensity\": 0.084,\n" +
            "                \"precipIntensityError\": 0.0107,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951380,\n" +
            "                \"precipIntensity\": 0.0864,\n" +
            "                \"precipIntensityError\": 0.0119,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951440,\n" +
            "                \"precipIntensity\": 0.0887,\n" +
            "                \"precipIntensityError\": 0.0125,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951500,\n" +
            "                \"precipIntensity\": 0.0909,\n" +
            "                \"precipIntensityError\": 0.013,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951560,\n" +
            "                \"precipIntensity\": 0.0913,\n" +
            "                \"precipIntensityError\": 0.0132,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951620,\n" +
            "                \"precipIntensity\": 0.0988,\n" +
            "                \"precipIntensityError\": 0.0152,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951680,\n" +
            "                \"precipIntensity\": 0.0994,\n" +
            "                \"precipIntensityError\": 0.0156,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951740,\n" +
            "                \"precipIntensity\": 0.1002,\n" +
            "                \"precipIntensityError\": 0.0159,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951800,\n" +
            "                \"precipIntensity\": 0.1018,\n" +
            "                \"precipIntensityError\": 0.0165,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"hourly\": {\n" +
            "        \"summary\": \"Rain throughout the day.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411945200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0551,\n" +
            "                \"precipProbability\": 0.94,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.51,\n" +
            "                \"apparentTemperature\": 75.51,\n" +
            "                \"dewPoint\": 72.52,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 1.75,\n" +
            "                \"windBearing\": 99,\n" +
            "                \"visibility\": 1.96,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1014.67,\n" +
            "                \"ozone\": 279.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948800,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0649,\n" +
            "                \"precipProbability\": 0.42,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 74.82,\n" +
            "                \"apparentTemperature\": 74.82,\n" +
            "                \"dewPoint\": 71.84,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 1.96,\n" +
            "                \"windBearing\": 53,\n" +
            "                \"visibility\": 3.37,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1014.62,\n" +
            "                \"ozone\": 279.52\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411952400,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0611,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.38,\n" +
            "                \"apparentTemperature\": 75.38,\n" +
            "                \"dewPoint\": 72.3,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 2.41,\n" +
            "                \"windBearing\": 46,\n" +
            "                \"visibility\": 4.64,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1014.56,\n" +
            "                \"ozone\": 279.74\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411956000,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0714,\n" +
            "                \"precipProbability\": 0.88,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.83,\n" +
            "                \"apparentTemperature\": 75.83,\n" +
            "                \"dewPoint\": 72.97,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 2.74,\n" +
            "                \"windBearing\": 42,\n" +
            "                \"visibility\": 5.39,\n" +
            "                \"cloudCover\": 0.98,\n" +
            "                \"pressure\": 1014.53,\n" +
            "                \"ozone\": 279.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411959600,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0575,\n" +
            "                \"precipProbability\": 0.87,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.96,\n" +
            "                \"apparentTemperature\": 75.96,\n" +
            "                \"dewPoint\": 73.14,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 3.45,\n" +
            "                \"windBearing\": 49,\n" +
            "                \"visibility\": 5.45,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1014.48,\n" +
            "                \"ozone\": 280.04\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411963200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0331,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.03,\n" +
            "                \"apparentTemperature\": 76.03,\n" +
            "                \"dewPoint\": 73.63,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 4.73,\n" +
            "                \"windBearing\": 59,\n" +
            "                \"visibility\": 5.46,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1014.29,\n" +
            "                \"ozone\": 279.96\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411966800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0219,\n" +
            "                \"precipProbability\": 0.45,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.94,\n" +
            "                \"apparentTemperature\": 75.94,\n" +
            "                \"dewPoint\": 73.71,\n" +
            "                \"humidity\": 0.93,\n" +
            "                \"windSpeed\": 5.67,\n" +
            "                \"windBearing\": 67,\n" +
            "                \"visibility\": 5.49,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1013.92,\n" +
            "                \"ozone\": 279.76\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411970400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0156,\n" +
            "                \"precipProbability\": 0.32,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.63,\n" +
            "                \"apparentTemperature\": 75.63,\n" +
            "                \"dewPoint\": 73.28,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 6.14,\n" +
            "                \"windBearing\": 69,\n" +
            "                \"visibility\": 4.88,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1013.65,\n" +
            "                \"ozone\": 279.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411974000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0147,\n" +
            "                \"precipProbability\": 0.31,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.46,\n" +
            "                \"apparentTemperature\": 75.46,\n" +
            "                \"dewPoint\": 73.43,\n" +
            "                \"humidity\": 0.93,\n" +
            "                \"windSpeed\": 6.15,\n" +
            "                \"windBearing\": 72,\n" +
            "                \"visibility\": 4.49,\n" +
            "                \"cloudCover\": 0.94,\n" +
            "                \"pressure\": 1013.31,\n" +
            "                \"ozone\": 279.47\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411977600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.017,\n" +
            "                \"precipProbability\": 0.33,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.36,\n" +
            "                \"apparentTemperature\": 75.36,\n" +
            "                \"dewPoint\": 73.36,\n" +
            "                \"humidity\": 0.94,\n" +
            "                \"windSpeed\": 6.08,\n" +
            "                \"windBearing\": 75,\n" +
            "                \"visibility\": 4.19,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.92,\n" +
            "                \"ozone\": 279.38\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411981200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0178,\n" +
            "                \"precipProbability\": 0.33,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.24,\n" +
            "                \"apparentTemperature\": 75.24,\n" +
            "                \"dewPoint\": 73.55,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 6.07,\n" +
            "                \"windBearing\": 80,\n" +
            "                \"visibility\": 3.81,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.64,\n" +
            "                \"ozone\": 279.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411984800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0153,\n" +
            "                \"precipProbability\": 0.32,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.04,\n" +
            "                \"apparentTemperature\": 75.04,\n" +
            "                \"dewPoint\": 73.45,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 5.93,\n" +
            "                \"windBearing\": 85,\n" +
            "                \"visibility\": 3.45,\n" +
            "                \"cloudCover\": 0.94,\n" +
            "                \"pressure\": 1012.62,\n" +
            "                \"ozone\": 279.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411988400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0104,\n" +
            "                \"precipProbability\": 0.3,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 74.91,\n" +
            "                \"apparentTemperature\": 74.91,\n" +
            "                \"dewPoint\": 73.37,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 5.81,\n" +
            "                \"windBearing\": 95,\n" +
            "                \"visibility\": 3.14,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1012.71,\n" +
            "                \"ozone\": 279.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411992000,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0076,\n" +
            "                \"precipProbability\": 0.24,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.2,\n" +
            "                \"apparentTemperature\": 75.2,\n" +
            "                \"dewPoint\": 73.26,\n" +
            "                \"humidity\": 0.94,\n" +
            "                \"windSpeed\": 5.77,\n" +
            "                \"windBearing\": 104,\n" +
            "                \"visibility\": 3.51,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1012.79,\n" +
            "                \"ozone\": 279.21\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411995600,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.007,\n" +
            "                \"precipProbability\": 0.26,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.55,\n" +
            "                \"apparentTemperature\": 76.55,\n" +
            "                \"dewPoint\": 73.79,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 6.34,\n" +
            "                \"windBearing\": 120,\n" +
            "                \"visibility\": 4.42,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.87,\n" +
            "                \"ozone\": 278.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411999200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0135,\n" +
            "                \"precipProbability\": 0.74,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.35,\n" +
            "                \"apparentTemperature\": 78.35,\n" +
            "                \"dewPoint\": 74.26,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 7.13,\n" +
            "                \"windBearing\": 136,\n" +
            "                \"visibility\": 6.54,\n" +
            "                \"cloudCover\": 0.89,\n" +
            "                \"pressure\": 1012.98,\n" +
            "                \"ozone\": 278.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412002800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0155,\n" +
            "                \"precipProbability\": 0.81,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.82,\n" +
            "                \"apparentTemperature\": 79.82,\n" +
            "                \"dewPoint\": 74.02,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 7.15,\n" +
            "                \"windBearing\": 146,\n" +
            "                \"visibility\": 8.14,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1013.01,\n" +
            "                \"ozone\": 278.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412006400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0277,\n" +
            "                \"precipProbability\": 0.87,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.66,\n" +
            "                \"apparentTemperature\": 85.53,\n" +
            "                \"dewPoint\": 73.62,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 6.8,\n" +
            "                \"windBearing\": 163,\n" +
            "                \"visibility\": 8.69,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1012.92,\n" +
            "                \"ozone\": 278.17\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412010000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.028,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.23,\n" +
            "                \"apparentTemperature\": 86.16,\n" +
            "                \"dewPoint\": 72.92,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 6.62,\n" +
            "                \"windBearing\": 178,\n" +
            "                \"visibility\": 9.06,\n" +
            "                \"cloudCover\": 0.88,\n" +
            "                \"pressure\": 1012.74,\n" +
            "                \"ozone\": 278.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412013600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0308,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.63,\n" +
            "                \"apparentTemperature\": 86.58,\n" +
            "                \"dewPoint\": 72.53,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 6.73,\n" +
            "                \"windBearing\": 191,\n" +
            "                \"visibility\": 9.28,\n" +
            "                \"cloudCover\": 0.9,\n" +
            "                \"pressure\": 1012.48,\n" +
            "                \"ozone\": 277.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412017200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0368,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.65,\n" +
            "                \"apparentTemperature\": 86.61,\n" +
            "                \"dewPoint\": 72.54,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 6.74,\n" +
            "                \"windBearing\": 201,\n" +
            "                \"visibility\": 9.59,\n" +
            "                \"cloudCover\": 0.92,\n" +
            "                \"pressure\": 1012.1,\n" +
            "                \"ozone\": 277.6\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412020800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0435,\n" +
            "                \"precipProbability\": 0.98,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.21,\n" +
            "                \"apparentTemperature\": 86.04,\n" +
            "                \"dewPoint\": 72.74,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 6.57,\n" +
            "                \"windBearing\": 209,\n" +
            "                \"visibility\": 9.78,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1011.64,\n" +
            "                \"ozone\": 277.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412024400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0454,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.41,\n" +
            "                \"apparentTemperature\": 84.81,\n" +
            "                \"dewPoint\": 72.94,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 6.54,\n" +
            "                \"windBearing\": 223,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.98,\n" +
            "                \"pressure\": 1011.29,\n" +
            "                \"ozone\": 276.92\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412028000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0386,\n" +
            "                \"precipProbability\": 0.84,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.61,\n" +
            "                \"apparentTemperature\": 79.61,\n" +
            "                \"dewPoint\": 73.02,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 5.73,\n" +
            "                \"windBearing\": 225,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1011.16,\n" +
            "                \"ozone\": 277.24\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412031600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0269,\n" +
            "                \"precipProbability\": 0.72,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.7,\n" +
            "                \"apparentTemperature\": 78.7,\n" +
            "                \"dewPoint\": 73.15,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 4.55,\n" +
            "                \"windBearing\": 224,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1011.14,\n" +
            "                \"ozone\": 277.85\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412035200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0176,\n" +
            "                \"precipProbability\": 0.63,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.94,\n" +
            "                \"apparentTemperature\": 77.94,\n" +
            "                \"dewPoint\": 73.23,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 3.69,\n" +
            "                \"windBearing\": 221,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1011.16,\n" +
            "                \"ozone\": 278.37\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412038800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0138,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.58,\n" +
            "                \"apparentTemperature\": 77.58,\n" +
            "                \"dewPoint\": 73.39,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 3.5,\n" +
            "                \"windBearing\": 216,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1011.23,\n" +
            "                \"ozone\": 278.61\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412042400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0124,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.35,\n" +
            "                \"apparentTemperature\": 77.35,\n" +
            "                \"dewPoint\": 73.4,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 3.66,\n" +
            "                \"windBearing\": 208,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.91,\n" +
            "                \"pressure\": 1011.34,\n" +
            "                \"ozone\": 278.77\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412046000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0117,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.08,\n" +
            "                \"apparentTemperature\": 77.08,\n" +
            "                \"dewPoint\": 73.31,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 3.89,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.87,\n" +
            "                \"pressure\": 1011.37,\n" +
            "                \"ozone\": 279.08\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412049600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0114,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.79,\n" +
            "                \"apparentTemperature\": 76.79,\n" +
            "                \"dewPoint\": 73.35,\n" +
            "                \"humidity\": 0.89,\n" +
            "                \"windSpeed\": 4,\n" +
            "                \"windBearing\": 201,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.84,\n" +
            "                \"pressure\": 1011.22,\n" +
            "                \"ozone\": 279.74\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412053200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0119,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.54,\n" +
            "                \"apparentTemperature\": 76.54,\n" +
            "                \"dewPoint\": 73.33,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 4.05,\n" +
            "                \"windBearing\": 202,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.8,\n" +
            "                \"pressure\": 1010.99,\n" +
            "                \"ozone\": 280.54\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412056800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0118,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.37,\n" +
            "                \"apparentTemperature\": 76.37,\n" +
            "                \"dewPoint\": 73.35,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 4.11,\n" +
            "                \"windBearing\": 205,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.78,\n" +
            "                \"pressure\": 1010.76,\n" +
            "                \"ozone\": 281.11\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412060400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0104,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.09,\n" +
            "                \"apparentTemperature\": 76.09,\n" +
            "                \"dewPoint\": 73.21,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.21,\n" +
            "                \"windBearing\": 211,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.76,\n" +
            "                \"pressure\": 1010.55,\n" +
            "                \"ozone\": 281.17\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412064000,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0084,\n" +
            "                \"precipProbability\": 0.41,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.77,\n" +
            "                \"apparentTemperature\": 75.77,\n" +
            "                \"dewPoint\": 73.01,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.37,\n" +
            "                \"windBearing\": 218,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1010.34,\n" +
            "                \"ozone\": 280.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412067600,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0067,\n" +
            "                \"precipProbability\": 0.28,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.61,\n" +
            "                \"apparentTemperature\": 75.61,\n" +
            "                \"dewPoint\": 72.92,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.53,\n" +
            "                \"windBearing\": 222,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1010.25,\n" +
            "                \"ozone\": 280.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412071200,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0.0034,\n" +
            "                \"precipProbability\": 0.11,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.47,\n" +
            "                \"apparentTemperature\": 75.47,\n" +
            "                \"dewPoint\": 72.91,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 4.34,\n" +
            "                \"windBearing\": 225,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.73,\n" +
            "                \"pressure\": 1010.36,\n" +
            "                \"ozone\": 281.2\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412074800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 75.44,\n" +
            "                \"apparentTemperature\": 75.44,\n" +
            "                \"dewPoint\": 72.94,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 3.95,\n" +
            "                \"windBearing\": 228,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.64,\n" +
            "                \"pressure\": 1010.56,\n" +
            "                \"ozone\": 281.57\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412078400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0044,\n" +
            "                \"precipProbability\": 0.13,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.86,\n" +
            "                \"apparentTemperature\": 75.86,\n" +
            "                \"dewPoint\": 73.07,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 3.83,\n" +
            "                \"windBearing\": 230,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.57,\n" +
            "                \"pressure\": 1010.77,\n" +
            "                \"ozone\": 281.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412082000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0219,\n" +
            "                \"precipProbability\": 0.43,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.13,\n" +
            "                \"apparentTemperature\": 77.13,\n" +
            "                \"dewPoint\": 73.34,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 4.22,\n" +
            "                \"windBearing\": 232,\n" +
            "                \"visibility\": 8.27,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1011.11,\n" +
            "                \"ozone\": 281.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412085600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0455,\n" +
            "                \"precipProbability\": 0.65,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.8,\n" +
            "                \"apparentTemperature\": 78.8,\n" +
            "                \"dewPoint\": 73.56,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 4.84,\n" +
            "                \"windBearing\": 235,\n" +
            "                \"visibility\": 5.95,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1011.49,\n" +
            "                \"ozone\": 281.93\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412089200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0637,\n" +
            "                \"precipProbability\": 0.81,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.11,\n" +
            "                \"apparentTemperature\": 84.57,\n" +
            "                \"dewPoint\": 73.65,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 5.4,\n" +
            "                \"windBearing\": 238,\n" +
            "                \"visibility\": 4.67,\n" +
            "                \"cloudCover\": 0.58,\n" +
            "                \"pressure\": 1011.68,\n" +
            "                \"ozone\": 281.69\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412092800,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0731,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.81,\n" +
            "                \"apparentTemperature\": 85.86,\n" +
            "                \"dewPoint\": 73.74,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 5.73,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 5.58,\n" +
            "                \"cloudCover\": 0.62,\n" +
            "                \"pressure\": 1011.56,\n" +
            "                \"ozone\": 281.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412096400,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0781,\n" +
            "                \"precipProbability\": 0.83,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.05,\n" +
            "                \"apparentTemperature\": 86.26,\n" +
            "                \"dewPoint\": 73.74,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 5.94,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 7.53,\n" +
            "                \"cloudCover\": 0.67,\n" +
            "                \"pressure\": 1011.26,\n" +
            "                \"ozone\": 280.11\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412100000,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0797,\n" +
            "                \"precipProbability\": 0.8,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.24,\n" +
            "                \"apparentTemperature\": 86.67,\n" +
            "                \"dewPoint\": 73.87,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 6.17,\n" +
            "                \"windBearing\": 241,\n" +
            "                \"visibility\": 8.73,\n" +
            "                \"cloudCover\": 0.68,\n" +
            "                \"pressure\": 1010.94,\n" +
            "                \"ozone\": 279.49\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412103600,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0786,\n" +
            "                \"precipProbability\": 0.79,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.25,\n" +
            "                \"apparentTemperature\": 86.7,\n" +
            "                \"dewPoint\": 73.92,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 6.68,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 8.09,\n" +
            "                \"cloudCover\": 0.65,\n" +
            "                \"pressure\": 1010.51,\n" +
            "                \"ozone\": 279.48\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412107200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0742,\n" +
            "                \"precipProbability\": 0.75,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.01,\n" +
            "                \"apparentTemperature\": 86.29,\n" +
            "                \"dewPoint\": 73.91,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 7.32,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 6.7,\n" +
            "                \"cloudCover\": 0.6,\n" +
            "                \"pressure\": 1010.08,\n" +
            "                \"ozone\": 279.75\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412110800,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0652,\n" +
            "                \"precipProbability\": 0.69,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.43,\n" +
            "                \"apparentTemperature\": 85.2,\n" +
            "                \"dewPoint\": 73.78,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 7.44,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 6.04,\n" +
            "                \"cloudCover\": 0.54,\n" +
            "                \"pressure\": 1009.81,\n" +
            "                \"ozone\": 279.88\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412114400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0474,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.3,\n" +
            "                \"apparentTemperature\": 79.3,\n" +
            "                \"dewPoint\": 73.51,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 6.45,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 7.02,\n" +
            "                \"cloudCover\": 0.5,\n" +
            "                \"pressure\": 1009.84,\n" +
            "                \"ozone\": 279.67\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412118000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0238,\n" +
            "                \"precipProbability\": 0.41,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.97,\n" +
            "                \"apparentTemperature\": 77.97,\n" +
            "                \"dewPoint\": 73.22,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 4.94,\n" +
            "                \"windBearing\": 239,\n" +
            "                \"visibility\": 8.73,\n" +
            "                \"cloudCover\": 0.45,\n" +
            "                \"pressure\": 1010.14,\n" +
            "                \"ozone\": 279.31\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"daily\": {\n" +
            "        \"summary\": \"Light rain today through Saturday, with temperatures falling to 76°F on Sunday.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411876800,\n" +
            "                \"summary\": \"Rain starting in the afternoon.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1411903373,\n" +
            "                \"sunsetTime\": 1411946476,\n" +
            "                \"moonPhase\": 0.14,\n" +
            "                \"precipIntensity\": 0.0264,\n" +
            "                \"precipIntensityMax\": 0.0714,\n" +
            "                \"precipIntensityMaxTime\": 1411956000,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 73.73,\n" +
            "                \"temperatureMinTime\": 1411894800,\n" +
            "                \"temperatureMax\": 87.88,\n" +
            "                \"temperatureMaxTime\": 1411934400,\n" +
            "                \"apparentTemperatureMin\": 73.73,\n" +
            "                \"apparentTemperatureMinTime\": 1411894800,\n" +
            "                \"apparentTemperatureMax\": 96.35,\n" +
            "                \"apparentTemperatureMaxTime\": 1411934400,\n" +
            "                \"dewPoint\": 73.41,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 3.94,\n" +
            "                \"windBearing\": 62,\n" +
            "                \"visibility\": 7.51,\n" +
            "                \"cloudCover\": 0.84,\n" +
            "                \"pressure\": 1015.31,\n" +
            "                \"ozone\": 278.05\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411963200,\n" +
            "                \"summary\": \"Light rain throughout the day.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1411989804,\n" +
            "                \"sunsetTime\": 1412032804,\n" +
            "                \"moonPhase\": 0.18,\n" +
            "                \"precipIntensity\": 0.0218,\n" +
            "                \"precipIntensityMax\": 0.0454,\n" +
            "                \"precipIntensityMaxTime\": 1412024400,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 74.91,\n" +
            "                \"temperatureMinTime\": 1411988400,\n" +
            "                \"temperatureMax\": 81.65,\n" +
            "                \"temperatureMaxTime\": 1412017200,\n" +
            "                \"apparentTemperatureMin\": 74.91,\n" +
            "                \"apparentTemperatureMinTime\": 1411988400,\n" +
            "                \"apparentTemperatureMax\": 86.61,\n" +
            "                \"apparentTemperatureMaxTime\": 1412017200,\n" +
            "                \"dewPoint\": 73.33,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 3.03,\n" +
            "                \"windBearing\": 146,\n" +
            "                \"visibility\": 7.25,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.43,\n" +
            "                \"ozone\": 278.62\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412049600,\n" +
            "                \"summary\": \"Rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412076235,\n" +
            "                \"sunsetTime\": 1412119132,\n" +
            "                \"moonPhase\": 0.21,\n" +
            "                \"precipIntensity\": 0.0302,\n" +
            "                \"precipIntensityMax\": 0.0797,\n" +
            "                \"precipIntensityMaxTime\": 1412100000,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 75.44,\n" +
            "                \"temperatureMinTime\": 1412074800,\n" +
            "                \"temperatureMax\": 81.25,\n" +
            "                \"temperatureMaxTime\": 1412103600,\n" +
            "                \"apparentTemperatureMin\": 75.44,\n" +
            "                \"apparentTemperatureMinTime\": 1412074800,\n" +
            "                \"apparentTemperatureMax\": 86.7,\n" +
            "                \"apparentTemperatureMaxTime\": 1412103600,\n" +
            "                \"dewPoint\": 73.39,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.54,\n" +
            "                \"windBearing\": 229,\n" +
            "                \"visibility\": 8.68,\n" +
            "                \"cloudCover\": 0.62,\n" +
            "                \"pressure\": 1010.78,\n" +
            "                \"ozone\": 280.35\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412136000,\n" +
            "                \"summary\": \"Rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412162666,\n" +
            "                \"sunsetTime\": 1412205461,\n" +
            "                \"moonPhase\": 0.25,\n" +
            "                \"precipIntensity\": 0.027,\n" +
            "                \"precipIntensityMax\": 0.1366,\n" +
            "                \"precipIntensityMaxTime\": 1412175600,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 74.38,\n" +
            "                \"temperatureMinTime\": 1412157600,\n" +
            "                \"temperatureMax\": 81.39,\n" +
            "                \"temperatureMaxTime\": 1412193600,\n" +
            "                \"apparentTemperatureMin\": 74.38,\n" +
            "                \"apparentTemperatureMinTime\": 1412157600,\n" +
            "                \"apparentTemperatureMax\": 87.33,\n" +
            "                \"apparentTemperatureMaxTime\": 1412193600,\n" +
            "                \"dewPoint\": 73.51,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 2.05,\n" +
            "                \"windBearing\": 189,\n" +
            "                \"visibility\": 9.23,\n" +
            "                \"cloudCover\": 0.5,\n" +
            "                \"pressure\": 1013.3,\n" +
            "                \"ozone\": 279.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412222400,\n" +
            "                \"summary\": \"Light rain starting in the afternoon, " +
            "continuing until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412249097,\n" +
            "                \"sunsetTime\": 1412291790,\n" +
            "                \"moonPhase\": 0.29,\n" +
            "                \"precipIntensity\": 0.0047,\n" +
            "                \"precipIntensityMax\": 0.0155,\n" +
            "                \"precipIntensityMaxTime\": 1412287200,\n" +
            "                \"precipProbability\": 0.56,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 71.87,\n" +
            "                \"temperatureMinTime\": 1412247600,\n" +
            "                \"temperatureMax\": 83.04,\n" +
            "                \"temperatureMaxTime\": 1412276400,\n" +
            "                \"apparentTemperatureMin\": 71.87,\n" +
            "                \"apparentTemperatureMinTime\": 1412247600,\n" +
            "                \"apparentTemperatureMax\": 87.96,\n" +
            "                \"apparentTemperatureMaxTime\": 1412276400,\n" +
            "                \"dewPoint\": 70.81,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 3.43,\n" +
            "                \"windBearing\": 100,\n" +
            "                \"cloudCover\": 0.18,\n" +
            "                \"pressure\": 1015.57,\n" +
            "                \"ozone\": 277.31\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412308800,\n" +
            "                \"summary\": \"Light rain starting in the afternoon, " +
            "continuing until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412335529,\n" +
            "                \"sunsetTime\": 1412378119,\n" +
            "                \"moonPhase\": 0.32,\n" +
            "                \"precipIntensity\": 0.0055,\n" +
            "                \"precipIntensityMax\": 0.0146,\n" +
            "                \"precipIntensityMaxTime\": 1412370000,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 71.64,\n" +
            "                \"temperatureMinTime\": 1412334000,\n" +
            "                \"temperatureMax\": 82.4,\n" +
            "                \"temperatureMaxTime\": 1412359200,\n" +
            "                \"apparentTemperatureMin\": 71.64,\n" +
            "                \"apparentTemperatureMinTime\": 1412334000,\n" +
            "                \"apparentTemperatureMax\": 88.05,\n" +
            "                \"apparentTemperatureMaxTime\": 1412359200,\n" +
            "                \"dewPoint\": 70.78,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 2.48,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"cloudCover\": 0.09,\n" +
            "                \"pressure\": 1015.19,\n" +
            "                \"ozone\": 274.32\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412395200,\n" +
            "                \"summary\": \"Light rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412421961,\n" +
            "                \"sunsetTime\": 1412464449,\n" +
            "                \"moonPhase\": 0.36,\n" +
            "                \"precipIntensity\": 0.0062,\n" +
            "                \"precipIntensityMax\": 0.0173,\n" +
            "                \"precipIntensityMaxTime\": 1412445600,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 70.53,\n" +
            "                \"temperatureMinTime\": 1412478000,\n" +
            "                \"temperatureMax\": 79.98,\n" +
            "                \"temperatureMaxTime\": 1412445600,\n" +
            "                \"apparentTemperatureMin\": 70.53,\n" +
            "                \"apparentTemperatureMinTime\": 1412478000,\n" +
            "                \"apparentTemperatureMax\": 79.98,\n" +
            "                \"apparentTemperatureMaxTime\": 1412445600,\n" +
            "                \"dewPoint\": 69.5,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 5.55,\n" +
            "                \"windBearing\": 288,\n" +
            "                \"cloudCover\": 0.34,\n" +
            "                \"pressure\": 1013.5,\n" +
            "                \"ozone\": 277.09\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481600,\n" +
            "                \"summary\": \"Clear throughout the day.\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"sunriseTime\": 1412508393,\n" +
            "                \"sunsetTime\": 1412550779,\n" +
            "                \"moonPhase\": 0.4,\n" +
            "                \"precipIntensity\": 0.002,\n" +
            "                \"precipIntensityMax\": 0.0033,\n" +
            "                \"precipIntensityMaxTime\": 1412488800,\n" +
            "                \"precipProbability\": 0.09,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 62.14,\n" +
            "                \"temperatureMinTime\": 1412506800,\n" +
            "                \"temperatureMax\": 76.23,\n" +
            "                \"temperatureMaxTime\": 1412539200,\n" +
            "                \"apparentTemperatureMin\": 62.14,\n" +
            "                \"apparentTemperatureMinTime\": 1412506800,\n" +
            "                \"apparentTemperatureMax\": 76.23,\n" +
            "                \"apparentTemperatureMaxTime\": 1412539200,\n" +
            "                \"dewPoint\": 57.79,\n" +
            "                \"humidity\": 0.68,\n" +
            "                \"windSpeed\": 6.54,\n" +
            "                \"windBearing\": 16,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1015.3,\n" +
            "                \"ozone\": 285.54\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"flags\": {\n" +
            "        \"sources\": [\n" +
            "            \"nwspa\",\n" +
            "            \"isd\",\n" +
            "            \"nearest-precip\",\n" +
            "            \"sref\",\n" +
            "            \"rap\",\n" +
            "            \"nam\",\n" +
            "            \"fnmoc\",\n" +
            "            \"rtma\",\n" +
            "            \"cmc\",\n" +
            "            \"gfs\",\n" +
            "            \"madis\",\n" +
            "            \"lamp\",\n" +
            "            \"darksky\"\n" +
            "        ],\n" +
            "        \"isd-stations\": [\n" +
            "            \"720655-99999\",\n" +
            "            \"722014-12818\",\n" +
            "            \"722014-99999\",\n" +
            "            \"724737-99999\",\n" +
            "            \"994082-99999\"\n" +
            "        ],\n" +
            "        \"madis-stations\": [\n" +
            "            \"AU655\",\n" +
            "            \"AU705\",\n" +
            "            \"AU749\",\n" +
            "            \"C6469\",\n" +
            "            \"C6533\",\n" +
            "            \"C8067\",\n" +
            "            \"D1496\",\n" +
            "            \"D3617\",\n" +
            "            \"D7271\",\n" +
            "            \"D7434\",\n" +
            "            \"E1772\",\n" +
            "            \"E2340\",\n" +
            "            \"KBKV\",\n" +
            "            \"KCGC\",\n" +
            "            \"KINF\",\n" +
            "            \"KOCF\"\n" +
            "        ],\n" +
            "        \"lamp-stations\": [\n" +
            "            \"KBKV\",\n" +
            "            \"KOCF\",\n" +
            "            \"KVVG\"\n" +
            "        ],\n" +
            "        \"darksky-stations\": [\n" +
            "            \"KTBW\"\n" +
            "        ],\n" +
            "        \"units\": \"us\"\n" +
            "    }\n" +
            "}";

    private static final String JSON_FLORIDA_FORECAST = "{\n" +
            "    \"latitude\": 28.8072,\n" +
            "    \"longitude\": -82.55,\n" +
            "    \"timezone\": \"America/New_York\",\n" +
            "    \"offset\": -4,\n" +
            "    \"currently\": {\n" +
            "        \"time\": 1411948124,\n" +
            "        \"summary\": \"Overcast\",\n" +
            "        \"icon\": \"cloudy\",\n" +
            "        \"nearestStormDistance\": 0,\n" +
            "        \"precipIntensity\": 0.0057,\n" +
            "        \"precipIntensityError\": 0.0037,\n" +
            "        \"precipProbability\": 0.34,\n" +
            "        \"precipType\": \"rain\",\n" +
            "        \"temperature\": 74.95,\n" +
            "        \"apparentTemperature\": 74.95,\n" +
            "        \"dewPoint\": 71.97,\n" +
            "        \"humidity\": 0.9,\n" +
            "        \"windSpeed\": 1.84,\n" +
            "        \"windBearing\": 60,\n" +
            "        \"visibility\": 3.1,\n" +
            "        \"cloudCover\": 1,\n" +
            "        \"pressure\": 1014.63,\n" +
            "        \"ozone\": 279.48\n" +
            "    },\n" +
            "    \"minutely\": {\n" +
            "        \"summary\": \"Light rain starting in 1 min.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411948080,\n" +
            "                \"precipIntensity\": 0.0049,\n" +
            "                \"precipIntensityError\": 0.0029,\n" +
            "                \"precipProbability\": 0.28,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948140,\n" +
            "                \"precipIntensity\": 0.006,\n" +
            "                \"precipIntensityError\": 0.004,\n" +
            "                \"precipProbability\": 0.36,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948200,\n" +
            "                \"precipIntensity\": 0.0068,\n" +
            "                \"precipIntensityError\": 0.0043,\n" +
            "                \"precipProbability\": 0.46,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948260,\n" +
            "                \"precipIntensity\": 0.0084,\n" +
            "                \"precipIntensityError\": 0.0053,\n" +
            "                \"precipProbability\": 0.59,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948320,\n" +
            "                \"precipIntensity\": 0.0091,\n" +
            "                \"precipIntensityError\": 0.0056,\n" +
            "                \"precipProbability\": 0.65,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948380,\n" +
            "                \"precipIntensity\": 0.0099,\n" +
            "                \"precipIntensityError\": 0.006,\n" +
            "                \"precipProbability\": 0.66,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948440,\n" +
            "                \"precipIntensity\": 0.0116,\n" +
            "                \"precipIntensityError\": 0.007,\n" +
            "                \"precipProbability\": 0.67,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948500,\n" +
            "                \"precipIntensity\": 0.0122,\n" +
            "                \"precipIntensityError\": 0.0072,\n" +
            "                \"precipProbability\": 0.69,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948560,\n" +
            "                \"precipIntensity\": 0.0135,\n" +
            "                \"precipIntensityError\": 0.0079,\n" +
            "                \"precipProbability\": 0.68,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948620,\n" +
            "                \"precipIntensity\": 0.0144,\n" +
            "                \"precipIntensityError\": 0.0084,\n" +
            "                \"precipProbability\": 0.68,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948680,\n" +
            "                \"precipIntensity\": 0.0154,\n" +
            "                \"precipIntensityError\": 0.0087,\n" +
            "                \"precipProbability\": 0.68,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948740,\n" +
            "                \"precipIntensity\": 0.0167,\n" +
            "                \"precipIntensityError\": 0.0095,\n" +
            "                \"precipProbability\": 0.68,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948800,\n" +
            "                \"precipIntensity\": 0.0174,\n" +
            "                \"precipIntensityError\": 0.0099,\n" +
            "                \"precipProbability\": 0.67,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948860,\n" +
            "                \"precipIntensity\": 0.019,\n" +
            "                \"precipIntensityError\": 0.0106,\n" +
            "                \"precipProbability\": 0.66,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948920,\n" +
            "                \"precipIntensity\": 0.0199,\n" +
            "                \"precipIntensityError\": 0.0112,\n" +
            "                \"precipProbability\": 0.66,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948980,\n" +
            "                \"precipIntensity\": 0.0208,\n" +
            "                \"precipIntensityError\": 0.0116,\n" +
            "                \"precipProbability\": 0.65,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949040,\n" +
            "                \"precipIntensity\": 0.0228,\n" +
            "                \"precipIntensityError\": 0.0125,\n" +
            "                \"precipProbability\": 0.63,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949100,\n" +
            "                \"precipIntensity\": 0.0241,\n" +
            "                \"precipIntensityError\": 0.0133,\n" +
            "                \"precipProbability\": 0.63,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949160,\n" +
            "                \"precipIntensity\": 0.0256,\n" +
            "                \"precipIntensityError\": 0.014,\n" +
            "                \"precipProbability\": 0.63,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949220,\n" +
            "                \"precipIntensity\": 0.0271,\n" +
            "                \"precipIntensityError\": 0.0147,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949280,\n" +
            "                \"precipIntensity\": 0.0289,\n" +
            "                \"precipIntensityError\": 0.0154,\n" +
            "                \"precipProbability\": 0.61,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949340,\n" +
            "                \"precipIntensity\": 0.0304,\n" +
            "                \"precipIntensityError\": 0.0162,\n" +
            "                \"precipProbability\": 0.61,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949400,\n" +
            "                \"precipIntensity\": 0.0317,\n" +
            "                \"precipIntensityError\": 0.0167,\n" +
            "                \"precipProbability\": 0.61,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949460,\n" +
            "                \"precipIntensity\": 0.0336,\n" +
            "                \"precipIntensityError\": 0.0175,\n" +
            "                \"precipProbability\": 0.6,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949520,\n" +
            "                \"precipIntensity\": 0.0353,\n" +
            "                \"precipIntensityError\": 0.0184,\n" +
            "                \"precipProbability\": 0.6,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949580,\n" +
            "                \"precipIntensity\": 0.0359,\n" +
            "                \"precipIntensityError\": 0.0185,\n" +
            "                \"precipProbability\": 0.6,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949640,\n" +
            "                \"precipIntensity\": 0.0379,\n" +
            "                \"precipIntensityError\": 0.0194,\n" +
            "                \"precipProbability\": 0.59,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949700,\n" +
            "                \"precipIntensity\": 0.0391,\n" +
            "                \"precipIntensityError\": 0.02,\n" +
            "                \"precipProbability\": 0.59,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949760,\n" +
            "                \"precipIntensity\": 0.0405,\n" +
            "                \"precipIntensityError\": 0.0206,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949820,\n" +
            "                \"precipIntensity\": 0.0413,\n" +
            "                \"precipIntensityError\": 0.0208,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949880,\n" +
            "                \"precipIntensity\": 0.0426,\n" +
            "                \"precipIntensityError\": 0.0213,\n" +
            "                \"precipProbability\": 0.57,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411949940,\n" +
            "                \"precipIntensity\": 0.0436,\n" +
            "                \"precipIntensityError\": 0.0217,\n" +
            "                \"precipProbability\": 0.56,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950000,\n" +
            "                \"precipIntensity\": 0.0444,\n" +
            "                \"precipIntensityError\": 0.0219,\n" +
            "                \"precipProbability\": 0.56,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950060,\n" +
            "                \"precipIntensity\": 0.0454,\n" +
            "                \"precipIntensityError\": 0.0224,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950120,\n" +
            "                \"precipIntensity\": 0.0463,\n" +
            "                \"precipIntensityError\": 0.0229,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950180,\n" +
            "                \"precipIntensity\": 0.046,\n" +
            "                \"precipIntensityError\": 0.0227,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950240,\n" +
            "                \"precipIntensity\": 0.0473,\n" +
            "                \"precipIntensityError\": 0.0232,\n" +
            "                \"precipProbability\": 0.53,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950300,\n" +
            "                \"precipIntensity\": 0.0476,\n" +
            "                \"precipIntensityError\": 0.0234,\n" +
            "                \"precipProbability\": 0.53,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950360,\n" +
            "                \"precipIntensity\": 0.0487,\n" +
            "                \"precipIntensityError\": 0.0238,\n" +
            "                \"precipProbability\": 0.52,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950420,\n" +
            "                \"precipIntensity\": 0.0488,\n" +
            "                \"precipIntensityError\": 0.0238,\n" +
            "                \"precipProbability\": 0.51,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950480,\n" +
            "                \"precipIntensity\": 0.0494,\n" +
            "                \"precipIntensityError\": 0.024,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950540,\n" +
            "                \"precipIntensity\": 0.0498,\n" +
            "                \"precipIntensityError\": 0.0242,\n" +
            "                \"precipProbability\": 0.49,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950600,\n" +
            "                \"precipIntensity\": 0.0501,\n" +
            "                \"precipIntensityError\": 0.0242,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950660,\n" +
            "                \"precipIntensity\": 0.0505,\n" +
            "                \"precipIntensityError\": 0.0244,\n" +
            "                \"precipProbability\": 0.48,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950720,\n" +
            "                \"precipIntensity\": 0.0507,\n" +
            "                \"precipIntensityError\": 0.0247,\n" +
            "                \"precipProbability\": 0.47,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950780,\n" +
            "                \"precipIntensity\": 0.0503,\n" +
            "                \"precipIntensityError\": 0.0244,\n" +
            "                \"precipProbability\": 0.46,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950840,\n" +
            "                \"precipIntensity\": 0.0513,\n" +
            "                \"precipIntensityError\": 0.0248,\n" +
            "                \"precipProbability\": 0.45,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950900,\n" +
            "                \"precipIntensity\": 0.0515,\n" +
            "                \"precipIntensityError\": 0.0249,\n" +
            "                \"precipProbability\": 0.44,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411950960,\n" +
            "                \"precipIntensity\": 0.0522,\n" +
            "                \"precipIntensityError\": 0.0252,\n" +
            "                \"precipProbability\": 0.43,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951020,\n" +
            "                \"precipIntensity\": 0.0523,\n" +
            "                \"precipIntensityError\": 0.0251,\n" +
            "                \"precipProbability\": 0.42,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951080,\n" +
            "                \"precipIntensity\": 0.0528,\n" +
            "                \"precipIntensityError\": 0.0252,\n" +
            "                \"precipProbability\": 0.41,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951140,\n" +
            "                \"precipIntensity\": 0.0531,\n" +
            "                \"precipIntensityError\": 0.0253,\n" +
            "                \"precipProbability\": 0.4,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951200,\n" +
            "                \"precipIntensity\": 0.0536,\n" +
            "                \"precipIntensityError\": 0.0253,\n" +
            "                \"precipProbability\": 0.39,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951260,\n" +
            "                \"precipIntensity\": 0.054,\n" +
            "                \"precipIntensityError\": 0.0255,\n" +
            "                \"precipProbability\": 0.39,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951320,\n" +
            "                \"precipIntensity\": 0.0541,\n" +
            "                \"precipIntensityError\": 0.0257,\n" +
            "                \"precipProbability\": 0.38,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951380,\n" +
            "                \"precipIntensity\": 0.0539,\n" +
            "                \"precipIntensityError\": 0.0254,\n" +
            "                \"precipProbability\": 0.37,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951440,\n" +
            "                \"precipIntensity\": 0.0547,\n" +
            "                \"precipIntensityError\": 0.0257,\n" +
            "                \"precipProbability\": 0.36,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951500,\n" +
            "                \"precipIntensity\": 0.0551,\n" +
            "                \"precipIntensityError\": 0.0258,\n" +
            "                \"precipProbability\": 0.35,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951560,\n" +
            "                \"precipIntensity\": 0.0556,\n" +
            "                \"precipIntensityError\": 0.026,\n" +
            "                \"precipProbability\": 0.34,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951620,\n" +
            "                \"precipIntensity\": 0.0554,\n" +
            "                \"precipIntensityError\": 0.0258,\n" +
            "                \"precipProbability\": 0.34,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411951680,\n" +
            "                \"precipIntensity\": 0.0558,\n" +
            "                \"precipIntensityError\": 0.026,\n" +
            "                \"precipProbability\": 0.33,\n" +
            "                \"precipType\": \"rain\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"hourly\": {\n" +
            "        \"summary\": \"Rain throughout the day.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411945200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0551,\n" +
            "                \"precipProbability\": 0.94,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.51,\n" +
            "                \"apparentTemperature\": 75.51,\n" +
            "                \"dewPoint\": 72.52,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 1.75,\n" +
            "                \"windBearing\": 99,\n" +
            "                \"visibility\": 1.96,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1014.67,\n" +
            "                \"ozone\": 279.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411948800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0346,\n" +
            "                \"precipProbability\": 0.42,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 74.82,\n" +
            "                \"apparentTemperature\": 74.82,\n" +
            "                \"dewPoint\": 71.84,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 1.96,\n" +
            "                \"windBearing\": 53,\n" +
            "                \"visibility\": 3.37,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1014.62,\n" +
            "                \"ozone\": 279.52\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411952400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0503,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.38,\n" +
            "                \"apparentTemperature\": 75.38,\n" +
            "                \"dewPoint\": 72.3,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 2.41,\n" +
            "                \"windBearing\": 46,\n" +
            "                \"visibility\": 4.64,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1014.56,\n" +
            "                \"ozone\": 279.74\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411956000,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0714,\n" +
            "                \"precipProbability\": 0.88,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.83,\n" +
            "                \"apparentTemperature\": 75.83,\n" +
            "                \"dewPoint\": 72.97,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 2.74,\n" +
            "                \"windBearing\": 42,\n" +
            "                \"visibility\": 5.39,\n" +
            "                \"cloudCover\": 0.98,\n" +
            "                \"pressure\": 1014.53,\n" +
            "                \"ozone\": 279.95\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411959600,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0575,\n" +
            "                \"precipProbability\": 0.87,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.96,\n" +
            "                \"apparentTemperature\": 75.96,\n" +
            "                \"dewPoint\": 73.14,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 3.45,\n" +
            "                \"windBearing\": 49,\n" +
            "                \"visibility\": 5.45,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1014.48,\n" +
            "                \"ozone\": 280.04\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411963200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0331,\n" +
            "                \"precipProbability\": 0.62,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.03,\n" +
            "                \"apparentTemperature\": 76.03,\n" +
            "                \"dewPoint\": 73.63,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 4.73,\n" +
            "                \"windBearing\": 59,\n" +
            "                \"visibility\": 5.46,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1014.29,\n" +
            "                \"ozone\": 279.96\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411966800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0219,\n" +
            "                \"precipProbability\": 0.45,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.94,\n" +
            "                \"apparentTemperature\": 75.94,\n" +
            "                \"dewPoint\": 73.71,\n" +
            "                \"humidity\": 0.93,\n" +
            "                \"windSpeed\": 5.67,\n" +
            "                \"windBearing\": 67,\n" +
            "                \"visibility\": 5.49,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1013.92,\n" +
            "                \"ozone\": 279.76\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411970400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0156,\n" +
            "                \"precipProbability\": 0.32,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.63,\n" +
            "                \"apparentTemperature\": 75.63,\n" +
            "                \"dewPoint\": 73.28,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 6.14,\n" +
            "                \"windBearing\": 69,\n" +
            "                \"visibility\": 4.88,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1013.65,\n" +
            "                \"ozone\": 279.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411974000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0147,\n" +
            "                \"precipProbability\": 0.31,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.46,\n" +
            "                \"apparentTemperature\": 75.46,\n" +
            "                \"dewPoint\": 73.43,\n" +
            "                \"humidity\": 0.93,\n" +
            "                \"windSpeed\": 6.15,\n" +
            "                \"windBearing\": 72,\n" +
            "                \"visibility\": 4.49,\n" +
            "                \"cloudCover\": 0.94,\n" +
            "                \"pressure\": 1013.31,\n" +
            "                \"ozone\": 279.47\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411977600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.017,\n" +
            "                \"precipProbability\": 0.33,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.36,\n" +
            "                \"apparentTemperature\": 75.36,\n" +
            "                \"dewPoint\": 73.36,\n" +
            "                \"humidity\": 0.94,\n" +
            "                \"windSpeed\": 6.08,\n" +
            "                \"windBearing\": 75,\n" +
            "                \"visibility\": 4.19,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.92,\n" +
            "                \"ozone\": 279.38\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411981200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0178,\n" +
            "                \"precipProbability\": 0.33,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.24,\n" +
            "                \"apparentTemperature\": 75.24,\n" +
            "                \"dewPoint\": 73.55,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 6.07,\n" +
            "                \"windBearing\": 80,\n" +
            "                \"visibility\": 3.81,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.64,\n" +
            "                \"ozone\": 279.3\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411984800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0153,\n" +
            "                \"precipProbability\": 0.32,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.04,\n" +
            "                \"apparentTemperature\": 75.04,\n" +
            "                \"dewPoint\": 73.45,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 5.93,\n" +
            "                \"windBearing\": 85,\n" +
            "                \"visibility\": 3.45,\n" +
            "                \"cloudCover\": 0.94,\n" +
            "                \"pressure\": 1012.62,\n" +
            "                \"ozone\": 279.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411988400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0104,\n" +
            "                \"precipProbability\": 0.3,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 74.91,\n" +
            "                \"apparentTemperature\": 74.91,\n" +
            "                \"dewPoint\": 73.37,\n" +
            "                \"humidity\": 0.95,\n" +
            "                \"windSpeed\": 5.81,\n" +
            "                \"windBearing\": 95,\n" +
            "                \"visibility\": 3.14,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1012.71,\n" +
            "                \"ozone\": 279.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411992000,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0076,\n" +
            "                \"precipProbability\": 0.24,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.2,\n" +
            "                \"apparentTemperature\": 75.2,\n" +
            "                \"dewPoint\": 73.26,\n" +
            "                \"humidity\": 0.94,\n" +
            "                \"windSpeed\": 5.77,\n" +
            "                \"windBearing\": 104,\n" +
            "                \"visibility\": 3.51,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1012.79,\n" +
            "                \"ozone\": 279.21\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411995600,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.007,\n" +
            "                \"precipProbability\": 0.26,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.55,\n" +
            "                \"apparentTemperature\": 76.55,\n" +
            "                \"dewPoint\": 73.79,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 6.34,\n" +
            "                \"windBearing\": 120,\n" +
            "                \"visibility\": 4.42,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.87,\n" +
            "                \"ozone\": 278.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411999200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0135,\n" +
            "                \"precipProbability\": 0.74,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.35,\n" +
            "                \"apparentTemperature\": 78.35,\n" +
            "                \"dewPoint\": 74.26,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 7.13,\n" +
            "                \"windBearing\": 136,\n" +
            "                \"visibility\": 6.54,\n" +
            "                \"cloudCover\": 0.89,\n" +
            "                \"pressure\": 1012.98,\n" +
            "                \"ozone\": 278.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412002800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0155,\n" +
            "                \"precipProbability\": 0.81,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.82,\n" +
            "                \"apparentTemperature\": 79.82,\n" +
            "                \"dewPoint\": 74.02,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 7.15,\n" +
            "                \"windBearing\": 146,\n" +
            "                \"visibility\": 8.14,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1013.01,\n" +
            "                \"ozone\": 278.29\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412006400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0277,\n" +
            "                \"precipProbability\": 0.87,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.66,\n" +
            "                \"apparentTemperature\": 85.53,\n" +
            "                \"dewPoint\": 73.62,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 6.8,\n" +
            "                \"windBearing\": 163,\n" +
            "                \"visibility\": 8.69,\n" +
            "                \"cloudCover\": 0.86,\n" +
            "                \"pressure\": 1012.92,\n" +
            "                \"ozone\": 278.17\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412010000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.028,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.23,\n" +
            "                \"apparentTemperature\": 86.16,\n" +
            "                \"dewPoint\": 72.92,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 6.62,\n" +
            "                \"windBearing\": 178,\n" +
            "                \"visibility\": 9.06,\n" +
            "                \"cloudCover\": 0.88,\n" +
            "                \"pressure\": 1012.74,\n" +
            "                \"ozone\": 278.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412013600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0308,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.63,\n" +
            "                \"apparentTemperature\": 86.58,\n" +
            "                \"dewPoint\": 72.53,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 6.73,\n" +
            "                \"windBearing\": 191,\n" +
            "                \"visibility\": 9.28,\n" +
            "                \"cloudCover\": 0.9,\n" +
            "                \"pressure\": 1012.48,\n" +
            "                \"ozone\": 277.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412017200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0368,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.65,\n" +
            "                \"apparentTemperature\": 86.61,\n" +
            "                \"dewPoint\": 72.54,\n" +
            "                \"humidity\": 0.74,\n" +
            "                \"windSpeed\": 6.74,\n" +
            "                \"windBearing\": 201,\n" +
            "                \"visibility\": 9.59,\n" +
            "                \"cloudCover\": 0.92,\n" +
            "                \"pressure\": 1012.1,\n" +
            "                \"ozone\": 277.6\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412020800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0435,\n" +
            "                \"precipProbability\": 0.98,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.21,\n" +
            "                \"apparentTemperature\": 86.04,\n" +
            "                \"dewPoint\": 72.74,\n" +
            "                \"humidity\": 0.76,\n" +
            "                \"windSpeed\": 6.57,\n" +
            "                \"windBearing\": 209,\n" +
            "                \"visibility\": 9.78,\n" +
            "                \"cloudCover\": 0.95,\n" +
            "                \"pressure\": 1011.64,\n" +
            "                \"ozone\": 277.12\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412024400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0454,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.41,\n" +
            "                \"apparentTemperature\": 84.81,\n" +
            "                \"dewPoint\": 72.94,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 6.54,\n" +
            "                \"windBearing\": 223,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.98,\n" +
            "                \"pressure\": 1011.29,\n" +
            "                \"ozone\": 276.92\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412028000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0386,\n" +
            "                \"precipProbability\": 0.84,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.61,\n" +
            "                \"apparentTemperature\": 79.61,\n" +
            "                \"dewPoint\": 73.02,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 5.73,\n" +
            "                \"windBearing\": 225,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1011.16,\n" +
            "                \"ozone\": 277.24\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412031600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0269,\n" +
            "                \"precipProbability\": 0.72,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.7,\n" +
            "                \"apparentTemperature\": 78.7,\n" +
            "                \"dewPoint\": 73.15,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 4.55,\n" +
            "                \"windBearing\": 224,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 1,\n" +
            "                \"pressure\": 1011.14,\n" +
            "                \"ozone\": 277.85\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412035200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0176,\n" +
            "                \"precipProbability\": 0.63,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.94,\n" +
            "                \"apparentTemperature\": 77.94,\n" +
            "                \"dewPoint\": 73.23,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 3.69,\n" +
            "                \"windBearing\": 221,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.99,\n" +
            "                \"pressure\": 1011.16,\n" +
            "                \"ozone\": 278.37\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412038800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0138,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.58,\n" +
            "                \"apparentTemperature\": 77.58,\n" +
            "                \"dewPoint\": 73.39,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 3.5,\n" +
            "                \"windBearing\": 216,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.96,\n" +
            "                \"pressure\": 1011.23,\n" +
            "                \"ozone\": 278.61\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412042400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0124,\n" +
            "                \"precipProbability\": 0.55,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.35,\n" +
            "                \"apparentTemperature\": 77.35,\n" +
            "                \"dewPoint\": 73.4,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 3.66,\n" +
            "                \"windBearing\": 208,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.91,\n" +
            "                \"pressure\": 1011.34,\n" +
            "                \"ozone\": 278.77\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412046000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0117,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.08,\n" +
            "                \"apparentTemperature\": 77.08,\n" +
            "                \"dewPoint\": 73.31,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 3.89,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.87,\n" +
            "                \"pressure\": 1011.37,\n" +
            "                \"ozone\": 279.08\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412049600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0114,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.79,\n" +
            "                \"apparentTemperature\": 76.79,\n" +
            "                \"dewPoint\": 73.35,\n" +
            "                \"humidity\": 0.89,\n" +
            "                \"windSpeed\": 4,\n" +
            "                \"windBearing\": 201,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.84,\n" +
            "                \"pressure\": 1011.22,\n" +
            "                \"ozone\": 279.74\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412053200,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0119,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.54,\n" +
            "                \"apparentTemperature\": 76.54,\n" +
            "                \"dewPoint\": 73.33,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 4.05,\n" +
            "                \"windBearing\": 202,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.8,\n" +
            "                \"pressure\": 1010.99,\n" +
            "                \"ozone\": 280.54\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412056800,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0118,\n" +
            "                \"precipProbability\": 0.54,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.37,\n" +
            "                \"apparentTemperature\": 76.37,\n" +
            "                \"dewPoint\": 73.35,\n" +
            "                \"humidity\": 0.9,\n" +
            "                \"windSpeed\": 4.11,\n" +
            "                \"windBearing\": 205,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.78,\n" +
            "                \"pressure\": 1010.76,\n" +
            "                \"ozone\": 281.11\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412060400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0104,\n" +
            "                \"precipProbability\": 0.5,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 76.09,\n" +
            "                \"apparentTemperature\": 76.09,\n" +
            "                \"dewPoint\": 73.21,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.21,\n" +
            "                \"windBearing\": 211,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.76,\n" +
            "                \"pressure\": 1010.55,\n" +
            "                \"ozone\": 281.17\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412064000,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0084,\n" +
            "                \"precipProbability\": 0.41,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.77,\n" +
            "                \"apparentTemperature\": 75.77,\n" +
            "                \"dewPoint\": 73.01,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.37,\n" +
            "                \"windBearing\": 218,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1010.34,\n" +
            "                \"ozone\": 280.99\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412067600,\n" +
            "                \"summary\": \"Drizzle\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0067,\n" +
            "                \"precipProbability\": 0.28,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.61,\n" +
            "                \"apparentTemperature\": 75.61,\n" +
            "                \"dewPoint\": 72.92,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 4.53,\n" +
            "                \"windBearing\": 222,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.79,\n" +
            "                \"pressure\": 1010.25,\n" +
            "                \"ozone\": 280.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412071200,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0.0034,\n" +
            "                \"precipProbability\": 0.11,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.47,\n" +
            "                \"apparentTemperature\": 75.47,\n" +
            "                \"dewPoint\": 72.91,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 4.34,\n" +
            "                \"windBearing\": 225,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.73,\n" +
            "                \"pressure\": 1010.36,\n" +
            "                \"ozone\": 281.2\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412074800,\n" +
            "                \"summary\": \"Mostly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-night\",\n" +
            "                \"precipIntensity\": 0,\n" +
            "                \"precipProbability\": 0,\n" +
            "                \"temperature\": 75.44,\n" +
            "                \"apparentTemperature\": 75.44,\n" +
            "                \"dewPoint\": 72.94,\n" +
            "                \"humidity\": 0.92,\n" +
            "                \"windSpeed\": 3.95,\n" +
            "                \"windBearing\": 228,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.64,\n" +
            "                \"pressure\": 1010.56,\n" +
            "                \"ozone\": 281.57\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412078400,\n" +
            "                \"summary\": \"Partly Cloudy\",\n" +
            "                \"icon\": \"partly-cloudy-day\",\n" +
            "                \"precipIntensity\": 0.0044,\n" +
            "                \"precipProbability\": 0.13,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 75.86,\n" +
            "                \"apparentTemperature\": 75.86,\n" +
            "                \"dewPoint\": 73.07,\n" +
            "                \"humidity\": 0.91,\n" +
            "                \"windSpeed\": 3.83,\n" +
            "                \"windBearing\": 230,\n" +
            "                \"visibility\": 10,\n" +
            "                \"cloudCover\": 0.57,\n" +
            "                \"pressure\": 1010.77,\n" +
            "                \"ozone\": 281.84\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412082000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0219,\n" +
            "                \"precipProbability\": 0.43,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.13,\n" +
            "                \"apparentTemperature\": 77.13,\n" +
            "                \"dewPoint\": 73.34,\n" +
            "                \"humidity\": 0.88,\n" +
            "                \"windSpeed\": 4.22,\n" +
            "                \"windBearing\": 232,\n" +
            "                \"visibility\": 8.27,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1011.11,\n" +
            "                \"ozone\": 281.94\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412085600,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0455,\n" +
            "                \"precipProbability\": 0.65,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 78.8,\n" +
            "                \"apparentTemperature\": 78.8,\n" +
            "                \"dewPoint\": 73.56,\n" +
            "                \"humidity\": 0.84,\n" +
            "                \"windSpeed\": 4.84,\n" +
            "                \"windBearing\": 235,\n" +
            "                \"visibility\": 5.95,\n" +
            "                \"cloudCover\": 0.56,\n" +
            "                \"pressure\": 1011.49,\n" +
            "                \"ozone\": 281.93\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412089200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0637,\n" +
            "                \"precipProbability\": 0.81,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.11,\n" +
            "                \"apparentTemperature\": 84.57,\n" +
            "                \"dewPoint\": 73.65,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 5.4,\n" +
            "                \"windBearing\": 238,\n" +
            "                \"visibility\": 4.67,\n" +
            "                \"cloudCover\": 0.58,\n" +
            "                \"pressure\": 1011.68,\n" +
            "                \"ozone\": 281.69\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412092800,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0731,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.81,\n" +
            "                \"apparentTemperature\": 85.86,\n" +
            "                \"dewPoint\": 73.74,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 5.73,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 5.58,\n" +
            "                \"cloudCover\": 0.62,\n" +
            "                \"pressure\": 1011.56,\n" +
            "                \"ozone\": 281.01\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412096400,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0781,\n" +
            "                \"precipProbability\": 0.83,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.05,\n" +
            "                \"apparentTemperature\": 86.26,\n" +
            "                \"dewPoint\": 73.74,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 5.94,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 7.53,\n" +
            "                \"cloudCover\": 0.67,\n" +
            "                \"pressure\": 1011.26,\n" +
            "                \"ozone\": 280.11\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412100000,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0797,\n" +
            "                \"precipProbability\": 0.8,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.24,\n" +
            "                \"apparentTemperature\": 86.67,\n" +
            "                \"dewPoint\": 73.87,\n" +
            "                \"humidity\": 0.78,\n" +
            "                \"windSpeed\": 6.17,\n" +
            "                \"windBearing\": 241,\n" +
            "                \"visibility\": 8.73,\n" +
            "                \"cloudCover\": 0.68,\n" +
            "                \"pressure\": 1010.94,\n" +
            "                \"ozone\": 279.49\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412103600,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0786,\n" +
            "                \"precipProbability\": 0.79,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.25,\n" +
            "                \"apparentTemperature\": 86.7,\n" +
            "                \"dewPoint\": 73.92,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 6.68,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 8.09,\n" +
            "                \"cloudCover\": 0.65,\n" +
            "                \"pressure\": 1010.51,\n" +
            "                \"ozone\": 279.48\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412107200,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0742,\n" +
            "                \"precipProbability\": 0.75,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 81.01,\n" +
            "                \"apparentTemperature\": 86.29,\n" +
            "                \"dewPoint\": 73.91,\n" +
            "                \"humidity\": 0.79,\n" +
            "                \"windSpeed\": 7.32,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 6.7,\n" +
            "                \"cloudCover\": 0.6,\n" +
            "                \"pressure\": 1010.08,\n" +
            "                \"ozone\": 279.75\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412110800,\n" +
            "                \"summary\": \"Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0652,\n" +
            "                \"precipProbability\": 0.69,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 80.43,\n" +
            "                \"apparentTemperature\": 85.2,\n" +
            "                \"dewPoint\": 73.78,\n" +
            "                \"humidity\": 0.8,\n" +
            "                \"windSpeed\": 7.44,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 6.04,\n" +
            "                \"cloudCover\": 0.54,\n" +
            "                \"pressure\": 1009.81,\n" +
            "                \"ozone\": 279.88\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412114400,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0474,\n" +
            "                \"precipProbability\": 0.58,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 79.3,\n" +
            "                \"apparentTemperature\": 79.3,\n" +
            "                \"dewPoint\": 73.51,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 6.45,\n" +
            "                \"windBearing\": 240,\n" +
            "                \"visibility\": 7.02,\n" +
            "                \"cloudCover\": 0.5,\n" +
            "                \"pressure\": 1009.84,\n" +
            "                \"ozone\": 279.67\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412118000,\n" +
            "                \"summary\": \"Light Rain\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"precipIntensity\": 0.0238,\n" +
            "                \"precipProbability\": 0.41,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperature\": 77.97,\n" +
            "                \"apparentTemperature\": 77.97,\n" +
            "                \"dewPoint\": 73.22,\n" +
            "                \"humidity\": 0.85,\n" +
            "                \"windSpeed\": 4.94,\n" +
            "                \"windBearing\": 239,\n" +
            "                \"visibility\": 8.73,\n" +
            "                \"cloudCover\": 0.45,\n" +
            "                \"pressure\": 1010.14,\n" +
            "                \"ozone\": 279.31\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"daily\": {\n" +
            "        \"summary\": \"Light rain today through Saturday, with temperatures falling to 76°F on Sunday.\",\n" +
            "        \"icon\": \"rain\",\n" +
            "        \"data\": [\n" +
            "            {\n" +
            "                \"time\": 1411876800,\n" +
            "                \"summary\": \"Rain starting in the afternoon.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1411903373,\n" +
            "                \"sunsetTime\": 1411946476,\n" +
            "                \"moonPhase\": 0.14,\n" +
            "                \"precipIntensity\": 0.0247,\n" +
            "                \"precipIntensityMax\": 0.0714,\n" +
            "                \"precipIntensityMaxTime\": 1411956000,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 73.73,\n" +
            "                \"temperatureMinTime\": 1411894800,\n" +
            "                \"temperatureMax\": 87.88,\n" +
            "                \"temperatureMaxTime\": 1411934400,\n" +
            "                \"apparentTemperatureMin\": 73.73,\n" +
            "                \"apparentTemperatureMinTime\": 1411894800,\n" +
            "                \"apparentTemperatureMax\": 96.35,\n" +
            "                \"apparentTemperatureMaxTime\": 1411934400,\n" +
            "                \"dewPoint\": 73.41,\n" +
            "                \"humidity\": 0.87,\n" +
            "                \"windSpeed\": 3.94,\n" +
            "                \"windBearing\": 62,\n" +
            "                \"visibility\": 7.51,\n" +
            "                \"cloudCover\": 0.84,\n" +
            "                \"pressure\": 1015.31,\n" +
            "                \"ozone\": 278.05\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1411963200,\n" +
            "                \"summary\": \"Light rain throughout the day.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1411989804,\n" +
            "                \"sunsetTime\": 1412032804,\n" +
            "                \"moonPhase\": 0.18,\n" +
            "                \"precipIntensity\": 0.0218,\n" +
            "                \"precipIntensityMax\": 0.0454,\n" +
            "                \"precipIntensityMaxTime\": 1412024400,\n" +
            "                \"precipProbability\": 1,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 74.91,\n" +
            "                \"temperatureMinTime\": 1411988400,\n" +
            "                \"temperatureMax\": 81.65,\n" +
            "                \"temperatureMaxTime\": 1412017200,\n" +
            "                \"apparentTemperatureMin\": 74.91,\n" +
            "                \"apparentTemperatureMinTime\": 1411988400,\n" +
            "                \"apparentTemperatureMax\": 86.61,\n" +
            "                \"apparentTemperatureMaxTime\": 1412017200,\n" +
            "                \"dewPoint\": 73.33,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 3.03,\n" +
            "                \"windBearing\": 146,\n" +
            "                \"visibility\": 7.25,\n" +
            "                \"cloudCover\": 0.93,\n" +
            "                \"pressure\": 1012.43,\n" +
            "                \"ozone\": 278.62\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412049600,\n" +
            "                \"summary\": \"Rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412076235,\n" +
            "                \"sunsetTime\": 1412119132,\n" +
            "                \"moonPhase\": 0.21,\n" +
            "                \"precipIntensity\": 0.0302,\n" +
            "                \"precipIntensityMax\": 0.0797,\n" +
            "                \"precipIntensityMaxTime\": 1412100000,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 75.44,\n" +
            "                \"temperatureMinTime\": 1412074800,\n" +
            "                \"temperatureMax\": 81.25,\n" +
            "                \"temperatureMaxTime\": 1412103600,\n" +
            "                \"apparentTemperatureMin\": 75.44,\n" +
            "                \"apparentTemperatureMinTime\": 1412074800,\n" +
            "                \"apparentTemperatureMax\": 86.7,\n" +
            "                \"apparentTemperatureMaxTime\": 1412103600,\n" +
            "                \"dewPoint\": 73.39,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 4.54,\n" +
            "                \"windBearing\": 229,\n" +
            "                \"visibility\": 8.68,\n" +
            "                \"cloudCover\": 0.62,\n" +
            "                \"pressure\": 1010.78,\n" +
            "                \"ozone\": 280.35\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412136000,\n" +
            "                \"summary\": \"Rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412162666,\n" +
            "                \"sunsetTime\": 1412205461,\n" +
            "                \"moonPhase\": 0.25,\n" +
            "                \"precipIntensity\": 0.027,\n" +
            "                \"precipIntensityMax\": 0.1366,\n" +
            "                \"precipIntensityMaxTime\": 1412175600,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 74.38,\n" +
            "                \"temperatureMinTime\": 1412157600,\n" +
            "                \"temperatureMax\": 81.39,\n" +
            "                \"temperatureMaxTime\": 1412193600,\n" +
            "                \"apparentTemperatureMin\": 74.38,\n" +
            "                \"apparentTemperatureMinTime\": 1412157600,\n" +
            "                \"apparentTemperatureMax\": 87.33,\n" +
            "                \"apparentTemperatureMaxTime\": 1412193600,\n" +
            "                \"dewPoint\": 73.51,\n" +
            "                \"humidity\": 0.86,\n" +
            "                \"windSpeed\": 2.05,\n" +
            "                \"windBearing\": 189,\n" +
            "                \"visibility\": 9.23,\n" +
            "                \"cloudCover\": 0.5,\n" +
            "                \"pressure\": 1013.3,\n" +
            "                \"ozone\": 279.58\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412222400,\n" +
            "                \"summary\": \"Light rain starting in the afternoon, " +
            "continuing until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412249097,\n" +
            "                \"sunsetTime\": 1412291790,\n" +
            "                \"moonPhase\": 0.29,\n" +
            "                \"precipIntensity\": 0.0047,\n" +
            "                \"precipIntensityMax\": 0.0155,\n" +
            "                \"precipIntensityMaxTime\": 1412287200,\n" +
            "                \"precipProbability\": 0.56,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 71.87,\n" +
            "                \"temperatureMinTime\": 1412247600,\n" +
            "                \"temperatureMax\": 83.04,\n" +
            "                \"temperatureMaxTime\": 1412276400,\n" +
            "                \"apparentTemperatureMin\": 71.87,\n" +
            "                \"apparentTemperatureMinTime\": 1412247600,\n" +
            "                \"apparentTemperatureMax\": 87.96,\n" +
            "                \"apparentTemperatureMaxTime\": 1412276400,\n" +
            "                \"dewPoint\": 70.81,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 3.43,\n" +
            "                \"windBearing\": 100,\n" +
            "                \"cloudCover\": 0.18,\n" +
            "                \"pressure\": 1015.57,\n" +
            "                \"ozone\": 277.31\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412308800,\n" +
            "                \"summary\": \"Light rain starting in the afternoon, " +
            "continuing until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412335529,\n" +
            "                \"sunsetTime\": 1412378119,\n" +
            "                \"moonPhase\": 0.32,\n" +
            "                \"precipIntensity\": 0.0055,\n" +
            "                \"precipIntensityMax\": 0.0146,\n" +
            "                \"precipIntensityMaxTime\": 1412370000,\n" +
            "                \"precipProbability\": 0.85,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 71.64,\n" +
            "                \"temperatureMinTime\": 1412334000,\n" +
            "                \"temperatureMax\": 82.4,\n" +
            "                \"temperatureMaxTime\": 1412359200,\n" +
            "                \"apparentTemperatureMin\": 71.64,\n" +
            "                \"apparentTemperatureMinTime\": 1412334000,\n" +
            "                \"apparentTemperatureMax\": 88.05,\n" +
            "                \"apparentTemperatureMaxTime\": 1412359200,\n" +
            "                \"dewPoint\": 70.78,\n" +
            "                \"humidity\": 0.83,\n" +
            "                \"windSpeed\": 2.48,\n" +
            "                \"windBearing\": 203,\n" +
            "                \"cloudCover\": 0.09,\n" +
            "                \"pressure\": 1015.19,\n" +
            "                \"ozone\": 274.32\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412395200,\n" +
            "                \"summary\": \"Light rain until evening.\",\n" +
            "                \"icon\": \"rain\",\n" +
            "                \"sunriseTime\": 1412421961,\n" +
            "                \"sunsetTime\": 1412464449,\n" +
            "                \"moonPhase\": 0.36,\n" +
            "                \"precipIntensity\": 0.0062,\n" +
            "                \"precipIntensityMax\": 0.0173,\n" +
            "                \"precipIntensityMaxTime\": 1412445600,\n" +
            "                \"precipProbability\": 0.93,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 70.53,\n" +
            "                \"temperatureMinTime\": 1412478000,\n" +
            "                \"temperatureMax\": 79.98,\n" +
            "                \"temperatureMaxTime\": 1412445600,\n" +
            "                \"apparentTemperatureMin\": 70.53,\n" +
            "                \"apparentTemperatureMinTime\": 1412478000,\n" +
            "                \"apparentTemperatureMax\": 79.98,\n" +
            "                \"apparentTemperatureMaxTime\": 1412445600,\n" +
            "                \"dewPoint\": 69.5,\n" +
            "                \"humidity\": 0.81,\n" +
            "                \"windSpeed\": 5.55,\n" +
            "                \"windBearing\": 288,\n" +
            "                \"cloudCover\": 0.34,\n" +
            "                \"pressure\": 1013.5,\n" +
            "                \"ozone\": 277.09\n" +
            "            },\n" +
            "            {\n" +
            "                \"time\": 1412481600,\n" +
            "                \"summary\": \"Clear throughout the day.\",\n" +
            "                \"icon\": \"clear-day\",\n" +
            "                \"sunriseTime\": 1412508393,\n" +
            "                \"sunsetTime\": 1412550779,\n" +
            "                \"moonPhase\": 0.4,\n" +
            "                \"precipIntensity\": 0.002,\n" +
            "                \"precipIntensityMax\": 0.0033,\n" +
            "                \"precipIntensityMaxTime\": 1412488800,\n" +
            "                \"precipProbability\": 0.09,\n" +
            "                \"precipType\": \"rain\",\n" +
            "                \"temperatureMin\": 62.14,\n" +
            "                \"temperatureMinTime\": 1412506800,\n" +
            "                \"temperatureMax\": 76.23,\n" +
            "                \"temperatureMaxTime\": 1412539200,\n" +
            "                \"apparentTemperatureMin\": 62.14,\n" +
            "                \"apparentTemperatureMinTime\": 1412506800,\n" +
            "                \"apparentTemperatureMax\": 76.23,\n" +
            "                \"apparentTemperatureMaxTime\": 1412539200,\n" +
            "                \"dewPoint\": 57.79,\n" +
            "                \"humidity\": 0.68,\n" +
            "                \"windSpeed\": 6.54,\n" +
            "                \"windBearing\": 16,\n" +
            "                \"cloudCover\": 0,\n" +
            "                \"pressure\": 1015.3,\n" +
            "                \"ozone\": 285.54\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"flags\": {\n" +
            "        \"sources\": [\n" +
            "            \"nwspa\",\n" +
            "            \"isd\",\n" +
            "            \"nearest-precip\",\n" +
            "            \"sref\",\n" +
            "            \"rap\",\n" +
            "            \"nam\",\n" +
            "            \"fnmoc\",\n" +
            "            \"rtma\",\n" +
            "            \"cmc\",\n" +
            "            \"gfs\",\n" +
            "            \"madis\",\n" +
            "            \"lamp\",\n" +
            "            \"darksky\"\n" +
            "        ],\n" +
            "        \"isd-stations\": [\n" +
            "            \"720655-99999\",\n" +
            "            \"722014-12818\",\n" +
            "            \"722014-99999\",\n" +
            "            \"724737-99999\",\n" +
            "            \"994082-99999\"\n" +
            "        ],\n" +
            "        \"madis-stations\": [\n" +
            "            \"AU655\",\n" +
            "            \"AU705\",\n" +
            "            \"AU749\",\n" +
            "            \"C6469\",\n" +
            "            \"C6533\",\n" +
            "            \"C8067\",\n" +
            "            \"D1496\",\n" +
            "            \"D3617\",\n" +
            "            \"D7271\",\n" +
            "            \"D7434\",\n" +
            "            \"E1772\",\n" +
            "            \"E2340\",\n" +
            "            \"KBKV\",\n" +
            "            \"KCGC\",\n" +
            "            \"KINF\",\n" +
            "            \"KOCF\"\n" +
            "        ],\n" +
            "        \"lamp-stations\": [\n" +
            "            \"KBKV\",\n" +
            "            \"KOCF\",\n" +
            "            \"KVVG\"\n" +
            "        ],\n" +
            "        \"darksky-stations\": [\n" +
            "            \"KTBW\"\n" +
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
}
