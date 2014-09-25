package com.osacky.umbrella.data.api;

import com.google.gson.Gson;
import com.osacky.umbrella.data.api.model.WeatherForecastResult;
import com.osacky.umbrella.data.api.weather.OpenWeatherService;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.http.Query;
import rx.Observable;

@Singleton
public class MockWeatherService implements OpenWeatherService {
    private final Gson mGson;

    @Inject MockWeatherService(Gson gson) {
        mGson = gson;
    }

    @Override
    public Observable<WeatherForecastResult> getWeatherForecast(
            @Query("lat") double latitude, @Query("lon") double longitude) {
        return Observable.just(mGson.fromJson(JSON_SEATTLE_FORECAST, WeatherForecastResult.class)).delay(1, TimeUnit.SECONDS);
    }

    @Override
    public Observable<WeatherForecastResult> getWeatherForecastFromCache(@Query("lat") double latitude, @Query("lon") double longitude) {
        return Observable.just(mGson.fromJson(JSON_SEATTLE_FORECAST, WeatherForecastResult.class));
    }

    public static final String JSON_SEATTLE_FORECAST = "{\n" +
            "    \"cod\": \"200\",\n" +
            "    \"message\": 0.0048,\n" +
            "    \"city\": {\n" +
            "        \"id\": 5809844,\n" +
            "        \"name\": \"Seattle\",\n" +
            "        \"coord\": {\n" +
            "            \"lon\": -122.332069,\n" +
            "            \"lat\": 47.606209\n" +
            "        },\n" +
            "        \"country\": \"US\",\n" +
            "        \"population\": 0\n" +
            "    },\n" +
            "    \"cnt\": 39,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"dt\": 1411160400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.09,\n" +
            "                \"temp_min\": 293.815,\n" +
            "                \"temp_max\": 296.09,\n" +
            "                \"pressure\": 1020.31,\n" +
            "                \"sea_level\": 1031.97,\n" +
            "                \"grnd_level\": 1020.31,\n" +
            "                \"humidity\": 66,\n" +
            "                \"temp_kf\": 2.27\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 44\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.41,\n" +
            "                \"deg\": 233.501\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-19 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411171200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.08,\n" +
            "                \"temp_min\": 293.918,\n" +
            "                \"temp_max\": 296.08,\n" +
            "                \"pressure\": 1019.93,\n" +
            "                \"sea_level\": 1031.5,\n" +
            "                \"grnd_level\": 1019.93,\n" +
            "                \"humidity\": 65,\n" +
            "                \"temp_kf\": 2.16\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"few clouds\",\n" +
            "                    \"icon\": \"02n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 12\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.12,\n" +
            "                \"deg\": 269.001\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411182000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.72,\n" +
            "                \"temp_min\": 290.677,\n" +
            "                \"temp_max\": 292.72,\n" +
            "                \"pressure\": 1020.23,\n" +
            "                \"sea_level\": 1032.16,\n" +
            "                \"grnd_level\": 1020.23,\n" +
            "                \"humidity\": 77,\n" +
            "                \"temp_kf\": 2.05\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.16,\n" +
            "                \"deg\": 359.501\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411192800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 290.78,\n" +
            "                \"temp_min\": 288.845,\n" +
            "                \"temp_max\": 290.78,\n" +
            "                \"pressure\": 1020.63,\n" +
            "                \"sea_level\": 1032.4,\n" +
            "                \"grnd_level\": 1020.63,\n" +
            "                \"humidity\": 84,\n" +
            "                \"temp_kf\": 1.93\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.77,\n" +
            "                \"deg\": 6.50418\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411203600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 289.64,\n" +
            "                \"temp_min\": 287.821,\n" +
            "                \"temp_max\": 289.64,\n" +
            "                \"pressure\": 1020.79,\n" +
            "                \"sea_level\": 1032.43,\n" +
            "                \"grnd_level\": 1020.79,\n" +
            "                \"humidity\": 93,\n" +
            "                \"temp_kf\": 1.82\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.57,\n" +
            "                \"deg\": 4.50714\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411214400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 288.76,\n" +
            "                \"temp_min\": 287.053,\n" +
            "                \"temp_max\": 288.76,\n" +
            "                \"pressure\": 1020.3,\n" +
            "                \"sea_level\": 1031.96,\n" +
            "                \"grnd_level\": 1020.3,\n" +
            "                \"humidity\": 97,\n" +
            "                \"temp_kf\": 1.71\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.86,\n" +
            "                \"deg\": 9.50162\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411225200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 288.67,\n" +
            "                \"temp_min\": 287.076,\n" +
            "                \"temp_max\": 288.67,\n" +
            "                \"pressure\": 1020.25,\n" +
            "                \"sea_level\": 1031.86,\n" +
            "                \"grnd_level\": 1020.25,\n" +
            "                \"humidity\": 95,\n" +
            "                \"temp_kf\": 1.59\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 801,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"few clouds\",\n" +
            "                    \"icon\": \"02d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 20\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.81,\n" +
            "                \"deg\": 13.0069\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411236000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.98,\n" +
            "                \"temp_min\": 291.502,\n" +
            "                \"temp_max\": 292.98,\n" +
            "                \"pressure\": 1019.65,\n" +
            "                \"sea_level\": 1031.2,\n" +
            "                \"grnd_level\": 1019.65,\n" +
            "                \"humidity\": 73,\n" +
            "                \"temp_kf\": 1.48\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.16,\n" +
            "                \"deg\": 10.0046\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411246800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.46,\n" +
            "                \"temp_min\": 295.093,\n" +
            "                \"temp_max\": 296.46,\n" +
            "                \"pressure\": 1017.43,\n" +
            "                \"sea_level\": 1028.89,\n" +
            "                \"grnd_level\": 1017.43,\n" +
            "                \"humidity\": 58,\n" +
            "                \"temp_kf\": 1.36\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.51,\n" +
            "                \"deg\": 4.5011\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-20 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411257600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 297.18,\n" +
            "                \"temp_min\": 295.933,\n" +
            "                \"temp_max\": 297.18,\n" +
            "                \"pressure\": 1014.93,\n" +
            "                \"sea_level\": 1026.62,\n" +
            "                \"grnd_level\": 1014.93,\n" +
            "                \"humidity\": 52,\n" +
            "                \"temp_kf\": 1.25\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.37,\n" +
            "                \"deg\": 1.00769\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411268400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 293.78,\n" +
            "                \"temp_min\": 292.64,\n" +
            "                \"temp_max\": 293.78,\n" +
            "                \"pressure\": 1014.12,\n" +
            "                \"sea_level\": 1025.94,\n" +
            "                \"grnd_level\": 1014.12,\n" +
            "                \"humidity\": 58,\n" +
            "                \"temp_kf\": 1.14\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.26,\n" +
            "                \"deg\": 357.501\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411279200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 290.96,\n" +
            "                \"temp_min\": 289.933,\n" +
            "                \"temp_max\": 290.96,\n" +
            "                \"pressure\": 1014.08,\n" +
            "                \"sea_level\": 1025.83,\n" +
            "                \"grnd_level\": 1014.08,\n" +
            "                \"humidity\": 70,\n" +
            "                \"temp_kf\": 1.02\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.52,\n" +
            "                \"deg\": 2.5094\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411290000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 288.28,\n" +
            "                \"temp_min\": 287.37,\n" +
            "                \"temp_max\": 288.28,\n" +
            "                \"pressure\": 1013.38,\n" +
            "                \"sea_level\": 1025.33,\n" +
            "                \"grnd_level\": 1013.38,\n" +
            "                \"humidity\": 82,\n" +
            "                \"temp_kf\": 0.91\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.47,\n" +
            "                \"deg\": 10.0014\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411300800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 286.44,\n" +
            "                \"temp_min\": 285.644,\n" +
            "                \"temp_max\": 286.44,\n" +
            "                \"pressure\": 1013.01,\n" +
            "                \"sea_level\": 1025.03,\n" +
            "                \"grnd_level\": 1013.01,\n" +
            "                \"humidity\": 91,\n" +
            "                \"temp_kf\": 0.8\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.87,\n" +
            "                \"deg\": 13.5022\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411311600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 287.09,\n" +
            "                \"temp_min\": 286.403,\n" +
            "                \"temp_max\": 287.09,\n" +
            "                \"pressure\": 1013.44,\n" +
            "                \"sea_level\": 1025.22,\n" +
            "                \"grnd_level\": 1013.44,\n" +
            "                \"humidity\": 89,\n" +
            "                \"temp_kf\": 0.68\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.86,\n" +
            "                \"deg\": 90.0014\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411322400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.68,\n" +
            "                \"temp_min\": 295.116,\n" +
            "                \"temp_max\": 295.68,\n" +
            "                \"pressure\": 1014.18,\n" +
            "                \"sea_level\": 1025.76,\n" +
            "                \"grnd_level\": 1014.18,\n" +
            "                \"humidity\": 61,\n" +
            "                \"temp_kf\": 0.57\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.42,\n" +
            "                \"deg\": 208.001\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411333200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 298.81,\n" +
            "                \"temp_min\": 298.353,\n" +
            "                \"temp_max\": 298.81,\n" +
            "                \"pressure\": 1013.62,\n" +
            "                \"sea_level\": 1025.25,\n" +
            "                \"grnd_level\": 1013.62,\n" +
            "                \"humidity\": 52,\n" +
            "                \"temp_kf\": 0.45\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.62,\n" +
            "                \"deg\": 221\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-21 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411344000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 298.71,\n" +
            "                \"temp_min\": 298.369,\n" +
            "                \"temp_max\": 298.71,\n" +
            "                \"pressure\": 1013.19,\n" +
            "                \"sea_level\": 1024.76,\n" +
            "                \"grnd_level\": 1013.19,\n" +
            "                \"humidity\": 53,\n" +
            "                \"temp_kf\": 0.34\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.67,\n" +
            "                \"deg\": 222.502\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411354800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.36,\n" +
            "                \"temp_min\": 295.133,\n" +
            "                \"temp_max\": 295.36,\n" +
            "                \"pressure\": 1014.22,\n" +
            "                \"sea_level\": 1025.81,\n" +
            "                \"grnd_level\": 1014.22,\n" +
            "                \"humidity\": 61,\n" +
            "                \"temp_kf\": 0.23\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.23,\n" +
            "                \"deg\": 231.507\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411365600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 291.93,\n" +
            "                \"temp_min\": 291.814,\n" +
            "                \"temp_max\": 291.93,\n" +
            "                \"pressure\": 1015.58,\n" +
            "                \"sea_level\": 1027.2,\n" +
            "                \"grnd_level\": 1015.58,\n" +
            "                \"humidity\": 70,\n" +
            "                \"temp_kf\": 0.11\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.67,\n" +
            "                \"deg\": 214\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411376400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 289.135,\n" +
            "                \"temp_min\": 289.135,\n" +
            "                \"temp_max\": 289.135,\n" +
            "                \"pressure\": 1015.67,\n" +
            "                \"sea_level\": 1027.34,\n" +
            "                \"grnd_level\": 1015.67,\n" +
            "                \"humidity\": 82\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.27,\n" +
            "                \"deg\": 186.501\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411387200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 287.195,\n" +
            "                \"temp_min\": 287.195,\n" +
            "                \"temp_max\": 287.195,\n" +
            "                \"pressure\": 1016.02,\n" +
            "                \"sea_level\": 1027.51,\n" +
            "                \"grnd_level\": 1016.02,\n" +
            "                \"humidity\": 93\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 44\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.21,\n" +
            "                \"deg\": 205.003\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411398000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 287.139,\n" +
            "                \"temp_min\": 287.139,\n" +
            "                \"temp_max\": 287.139,\n" +
            "                \"pressure\": 1016.64,\n" +
            "                \"sea_level\": 1028.18,\n" +
            "                \"grnd_level\": 1016.64,\n" +
            "                \"humidity\": 94\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.01,\n" +
            "                \"deg\": 201.502\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411408800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 289.787,\n" +
            "                \"temp_min\": 289.787,\n" +
            "                \"temp_max\": 289.787,\n" +
            "                \"pressure\": 1016.79,\n" +
            "                \"sea_level\": 1028.33,\n" +
            "                \"grnd_level\": 1016.79,\n" +
            "                \"humidity\": 79\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.96,\n" +
            "                \"deg\": 187.502\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411419600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.446,\n" +
            "                \"temp_min\": 292.446,\n" +
            "                \"temp_max\": 292.446,\n" +
            "                \"pressure\": 1016.41,\n" +
            "                \"sea_level\": 1027.9,\n" +
            "                \"grnd_level\": 1016.41,\n" +
            "                \"humidity\": 66\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 76\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.21,\n" +
            "                \"deg\": 202.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-22 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411430400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.591,\n" +
            "                \"temp_min\": 292.591,\n" +
            "                \"temp_max\": 292.591,\n" +
            "                \"pressure\": 1016.23,\n" +
            "                \"sea_level\": 1027.77,\n" +
            "                \"grnd_level\": 1016.23,\n" +
            "                \"humidity\": 63\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.17,\n" +
            "                \"deg\": 216.504\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411441200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 290.755,\n" +
            "                \"temp_min\": 290.755,\n" +
            "                \"temp_max\": 290.755,\n" +
            "                \"pressure\": 1016.93,\n" +
            "                \"sea_level\": 1028.68,\n" +
            "                \"grnd_level\": 1016.93,\n" +
            "                \"humidity\": 70\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.62,\n" +
            "                \"deg\": 220.507\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411452000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 289.364,\n" +
            "                \"temp_min\": 289.364,\n" +
            "                \"temp_max\": 289.364,\n" +
            "                \"pressure\": 1017.18,\n" +
            "                \"sea_level\": 1028.84,\n" +
            "                \"grnd_level\": 1017.18,\n" +
            "                \"humidity\": 81\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.96,\n" +
            "                \"deg\": 214.001\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411462800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 288.087,\n" +
            "                \"temp_min\": 288.087,\n" +
            "                \"temp_max\": 288.087,\n" +
            "                \"pressure\": 1017.31,\n" +
            "                \"sea_level\": 1028.82,\n" +
            "                \"grnd_level\": 1017.31,\n" +
            "                \"humidity\": 89\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 36\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.1,\n" +
            "                \"deg\": 171.001\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411473600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 286.258,\n" +
            "                \"temp_min\": 286.258,\n" +
            "                \"temp_max\": 286.258,\n" +
            "                \"pressure\": 1017.02,\n" +
            "                \"sea_level\": 1028.63,\n" +
            "                \"grnd_level\": 1017.02,\n" +
            "                \"humidity\": 95\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.26,\n" +
            "                \"deg\": 132.508\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411484400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 286.27,\n" +
            "                \"temp_min\": 286.27,\n" +
            "                \"temp_max\": 286.27,\n" +
            "                \"pressure\": 1016.85,\n" +
            "                \"sea_level\": 1028.64,\n" +
            "                \"grnd_level\": 1016.85,\n" +
            "                \"humidity\": 93\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.97,\n" +
            "                \"deg\": 352.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411495200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.336,\n" +
            "                \"temp_min\": 292.336,\n" +
            "                \"temp_max\": 292.336,\n" +
            "                \"pressure\": 1016.41,\n" +
            "                \"sea_level\": 1027.94,\n" +
            "                \"grnd_level\": 1016.41,\n" +
            "                \"humidity\": 72\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.61,\n" +
            "                \"deg\": 355.007\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411506000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.274,\n" +
            "                \"temp_min\": 295.274,\n" +
            "                \"temp_max\": 295.274,\n" +
            "                \"pressure\": 1014.42,\n" +
            "                \"sea_level\": 1026.16,\n" +
            "                \"grnd_level\": 1014.42,\n" +
            "                \"humidity\": 61\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 800,\n" +
            "                    \"main\": \"Clear\",\n" +
            "                    \"description\": \"sky is clear\",\n" +
            "                    \"icon\": \"01d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 0\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.43,\n" +
            "                \"deg\": 4.50247\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-23 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411516800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.108,\n" +
            "                \"temp_min\": 296.108,\n" +
            "                \"temp_max\": 296.108,\n" +
            "                \"pressure\": 1013.39,\n" +
            "                \"sea_level\": 1025.02,\n" +
            "                \"grnd_level\": 1013.39,\n" +
            "                \"humidity\": 55\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 36\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.81,\n" +
            "                \"deg\": 51.0009\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411527600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 292.203,\n" +
            "                \"temp_min\": 292.203,\n" +
            "                \"temp_max\": 292.203,\n" +
            "                \"pressure\": 1012.86,\n" +
            "                \"sea_level\": 1024.72,\n" +
            "                \"grnd_level\": 1012.86,\n" +
            "                \"humidity\": 69\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 80\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.91,\n" +
            "                \"deg\": 329.502\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411538400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 291.155,\n" +
            "                \"temp_min\": 291.155,\n" +
            "                \"temp_max\": 291.155,\n" +
            "                \"pressure\": 1011.73,\n" +
            "                \"sea_level\": 1023.6,\n" +
            "                \"grnd_level\": 1011.73,\n" +
            "                \"humidity\": 70\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 68\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.81,\n" +
            "                \"deg\": 34.503\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411549200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 291.482,\n" +
            "                \"temp_min\": 291.482,\n" +
            "                \"temp_max\": 291.482,\n" +
            "                \"pressure\": 1010.13,\n" +
            "                \"sea_level\": 1022.03,\n" +
            "                \"grnd_level\": 1010.13,\n" +
            "                \"humidity\": 62\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 68\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.41,\n" +
            "                \"deg\": 59.0021\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411560000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 291.369,\n" +
            "                \"temp_min\": 291.369,\n" +
            "                \"temp_max\": 291.369,\n" +
            "                \"pressure\": 1009.79,\n" +
            "                \"sea_level\": 1021.6,\n" +
            "                \"grnd_level\": 1009.79,\n" +
            "                \"humidity\": 62\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.66,\n" +
            "                \"deg\": 118.501\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1411570800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 290.821,\n" +
            "                \"temp_min\": 290.821,\n" +
            "                \"temp_max\": 290.821,\n" +
            "                \"pressure\": 1009.05,\n" +
            "                \"sea_level\": 1020.84,\n" +
            "                \"grnd_level\": 1009.05,\n" +
            "                \"humidity\": 70\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.92,\n" +
            "                \"deg\": 107.502\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-24 15:00:00\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    private static final String JSON_FORECAST = "{\n" +
            "    \"cod\": \"200\",\n" +
            "    \"message\": 0.0957,\n" +
            "    \"city\": {\n" +
            "        \"id\": 1851632,\n" +
            "        \"name\": \"Shuzenji\",\n" +
            "        \"coord\": {\n" +
            "            \"lon\": 138.933334,\n" +
            "            \"lat\": 34.966671\n" +
            "        },\n" +
            "        \"country\": \"JP\",\n" +
            "        \"population\": 0\n" +
            "    },\n" +
            "    \"cnt\": 35,\n" +
            "    \"list\": [\n" +
            "        {\n" +
            "            \"dt\": 1409194800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.57,\n" +
            "                \"temp_min\": 296.57,\n" +
            "                \"temp_max\": 296.71,\n" +
            "                \"pressure\": 1014.72,\n" +
            "                \"sea_level\": 1027.1,\n" +
            "                \"grnd_level\": 1014.72,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.14\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.77,\n" +
            "                \"deg\": 47.5019\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409205600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 297.19,\n" +
            "                \"temp_min\": 297.19,\n" +
            "                \"temp_max\": 297.319,\n" +
            "                \"pressure\": 1014.5,\n" +
            "                \"sea_level\": 1026.97,\n" +
            "                \"grnd_level\": 1014.5,\n" +
            "                \"humidity\": 99,\n" +
            "                \"temp_kf\": -0.13\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.4,\n" +
            "                \"deg\": 75.5007\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409216400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.77,\n" +
            "                \"temp_min\": 296.77,\n" +
            "                \"temp_max\": 296.891,\n" +
            "                \"pressure\": 1014.87,\n" +
            "                \"sea_level\": 1026.97,\n" +
            "                \"grnd_level\": 1014.87,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.13\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.41,\n" +
            "                \"deg\": 54.0062\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409227200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.47,\n" +
            "                \"temp_min\": 296.47,\n" +
            "                \"temp_max\": 296.593,\n" +
            "                \"pressure\": 1015.52,\n" +
            "                \"sea_level\": 1028.08,\n" +
            "                \"grnd_level\": 1015.52,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.12\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.96,\n" +
            "                \"deg\": 22.5013\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409238000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.22,\n" +
            "                \"temp_min\": 296.22,\n" +
            "                \"temp_max\": 296.334,\n" +
            "                \"pressure\": 1015.53,\n" +
            "                \"sea_level\": 1027.99,\n" +
            "                \"grnd_level\": 1015.53,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.11\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.32,\n" +
            "                \"deg\": 36.0032\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409248800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.92,\n" +
            "                \"temp_min\": 295.92,\n" +
            "                \"temp_max\": 296.023,\n" +
            "                \"pressure\": 1015.56,\n" +
            "                \"sea_level\": 1028.1,\n" +
            "                \"grnd_level\": 1015.56,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.1\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 36\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.06,\n" +
            "                \"deg\": 38.5002\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409259600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.75,\n" +
            "                \"temp_min\": 295.75,\n" +
            "                \"temp_max\": 295.848,\n" +
            "                \"pressure\": 1015.48,\n" +
            "                \"sea_level\": 1027.98,\n" +
            "                \"grnd_level\": 1015.48,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.1\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.21,\n" +
            "                \"deg\": 42.0011\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-28 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409270400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.46,\n" +
            "                \"temp_min\": 296.46,\n" +
            "                \"temp_max\": 296.553,\n" +
            "                \"pressure\": 1016.35,\n" +
            "                \"sea_level\": 1027.98,\n" +
            "                \"grnd_level\": 1016.35,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.09\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.71,\n" +
            "                \"deg\": 47.5027\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409281200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 297.89,\n" +
            "                \"temp_min\": 297.89,\n" +
            "                \"temp_max\": 297.977,\n" +
            "                \"pressure\": 1016.27,\n" +
            "                \"sea_level\": 1028.66,\n" +
            "                \"grnd_level\": 1016.27,\n" +
            "                \"humidity\": 96,\n" +
            "                \"temp_kf\": -0.08\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.16,\n" +
            "                \"deg\": 81.0038\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409292000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.88,\n" +
            "                \"temp_min\": 296.88,\n" +
            "                \"temp_max\": 296.96,\n" +
            "                \"pressure\": 1014.9,\n" +
            "                \"sea_level\": 1027.29,\n" +
            "                \"grnd_level\": 1014.9,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.08\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.92,\n" +
            "                \"deg\": 61.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409302800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.41,\n" +
            "                \"temp_min\": 295.41,\n" +
            "                \"temp_max\": 295.475,\n" +
            "                \"pressure\": 1015.41,\n" +
            "                \"sea_level\": 1027.82,\n" +
            "                \"grnd_level\": 1015.41,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.07\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.57,\n" +
            "                \"deg\": 50.5012\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409313600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.51,\n" +
            "                \"temp_min\": 294.51,\n" +
            "                \"temp_max\": 294.571,\n" +
            "                \"pressure\": 1016,\n" +
            "                \"sea_level\": 1028.39,\n" +
            "                \"grnd_level\": 1016,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.06\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.96,\n" +
            "                \"deg\": 39.5004\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409324400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.57,\n" +
            "                \"temp_min\": 294.57,\n" +
            "                \"temp_max\": 294.624,\n" +
            "                \"pressure\": 1014.78,\n" +
            "                \"sea_level\": 1027.24,\n" +
            "                \"grnd_level\": 1014.78,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.06\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.46,\n" +
            "                \"deg\": 31.5067\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409335200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.46,\n" +
            "                \"temp_min\": 294.46,\n" +
            "                \"temp_max\": 294.507,\n" +
            "                \"pressure\": 1013.23,\n" +
            "                \"sea_level\": 1025.69,\n" +
            "                \"grnd_level\": 1013.23,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.05\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.16,\n" +
            "                \"deg\": 31.0028\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409346000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.13,\n" +
            "                \"temp_min\": 294.13,\n" +
            "                \"temp_max\": 294.174,\n" +
            "                \"pressure\": 1012.84,\n" +
            "                \"sea_level\": 1025.39,\n" +
            "                \"grnd_level\": 1012.84,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.04\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 5.45,\n" +
            "                \"deg\": 11.5005\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-29 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409356800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 293.98,\n" +
            "                \"temp_min\": 293.98,\n" +
            "                \"temp_max\": 294.013,\n" +
            "                \"pressure\": 1013.27,\n" +
            "                \"sea_level\": 1025.66,\n" +
            "                \"grnd_level\": 1013.27,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.03\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.07,\n" +
            "                \"deg\": 17.5023\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 10.5\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409367600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.71,\n" +
            "                \"temp_min\": 294.71,\n" +
            "                \"temp_max\": 294.737,\n" +
            "                \"pressure\": 1012.03,\n" +
            "                \"sea_level\": 1024.46,\n" +
            "                \"grnd_level\": 1012.03,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.03\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.02,\n" +
            "                \"deg\": 24.5013\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 4\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409378400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.53,\n" +
            "                \"temp_min\": 295.53,\n" +
            "                \"temp_max\": 295.546,\n" +
            "                \"pressure\": 1011.04,\n" +
            "                \"sea_level\": 1023.27,\n" +
            "                \"grnd_level\": 1011.04,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.02\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"light rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.85,\n" +
            "                \"deg\": 5.50616\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 1\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409389200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.09,\n" +
            "                \"temp_min\": 296.09,\n" +
            "                \"temp_max\": 296.105,\n" +
            "                \"pressure\": 1010.91,\n" +
            "                \"sea_level\": 1023.25,\n" +
            "                \"grnd_level\": 1010.91,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.01\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 68\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.33,\n" +
            "                \"deg\": 9.01447\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409400000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.05,\n" +
            "                \"temp_min\": 296.05,\n" +
            "                \"temp_max\": 296.058,\n" +
            "                \"pressure\": 1011.42,\n" +
            "                \"sea_level\": 1023.98,\n" +
            "                \"grnd_level\": 1011.42,\n" +
            "                \"humidity\": 100,\n" +
            "                \"temp_kf\": -0.01\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 32\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.75,\n" +
            "                \"deg\": 334.501\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409410800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.91,\n" +
            "                \"temp_min\": 295.91,\n" +
            "                \"temp_max\": 295.91,\n" +
            "                \"pressure\": 1011.41,\n" +
            "                \"sea_level\": 1023.59,\n" +
            "                \"grnd_level\": 1011.41,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 801,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"few clouds\",\n" +
            "                    \"icon\": \"02n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 24\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.21,\n" +
            "                \"deg\": 321.009\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409421600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.549,\n" +
            "                \"temp_min\": 294.549,\n" +
            "                \"temp_max\": 294.549,\n" +
            "                \"pressure\": 1015.61,\n" +
            "                \"sea_level\": 1028.02,\n" +
            "                \"grnd_level\": 1015.61,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 6.17,\n" +
            "                \"deg\": 44.0007\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409432400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.535,\n" +
            "                \"temp_min\": 295.535,\n" +
            "                \"temp_max\": 295.535,\n" +
            "                \"pressure\": 1011.85,\n" +
            "                \"sea_level\": 1024.26,\n" +
            "                \"grnd_level\": 1011.85,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 44\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.46,\n" +
            "                \"deg\": 12.5017\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-30 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409443200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.925,\n" +
            "                \"temp_min\": 296.925,\n" +
            "                \"temp_max\": 296.925,\n" +
            "                \"pressure\": 1013.49,\n" +
            "                \"sea_level\": 1025.94,\n" +
            "                \"grnd_level\": 1013.49,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 76\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 1.07,\n" +
            "                \"deg\": 49.0001\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409454000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.48,\n" +
            "                \"temp_min\": 296.48,\n" +
            "                \"temp_max\": 296.48,\n" +
            "                \"pressure\": 1013.55,\n" +
            "                \"sea_level\": 1025.85,\n" +
            "                \"grnd_level\": 1013.55,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.27,\n" +
            "                \"deg\": 307.01\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409464800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.852,\n" +
            "                \"temp_min\": 296.852,\n" +
            "                \"temp_max\": 296.852,\n" +
            "                \"pressure\": 1012.5,\n" +
            "                \"sea_level\": 1024.99,\n" +
            "                \"grnd_level\": 1012.5,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 804,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"overcast clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 100\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.11,\n" +
            "                \"deg\": 15.0009\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409475600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.846,\n" +
            "                \"temp_min\": 296.846,\n" +
            "                \"temp_max\": 296.846,\n" +
            "                \"pressure\": 1012.78,\n" +
            "                \"sea_level\": 1025.18,\n" +
            "                \"grnd_level\": 1012.78,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 80\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.02,\n" +
            "                \"deg\": 264.502\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 09:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409486400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.366,\n" +
            "                \"temp_min\": 296.366,\n" +
            "                \"temp_max\": 296.366,\n" +
            "                \"pressure\": 1014.2,\n" +
            "                \"sea_level\": 1026.56,\n" +
            "                \"grnd_level\": 1014.2,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 56\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 0.66,\n" +
            "                \"deg\": 273.502\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 12:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409497200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.325,\n" +
            "                \"temp_min\": 296.325,\n" +
            "                \"temp_max\": 296.325,\n" +
            "                \"pressure\": 1014.23,\n" +
            "                \"sea_level\": 1026.67,\n" +
            "                \"grnd_level\": 1014.23,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 803,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"broken clouds\",\n" +
            "                    \"icon\": \"04n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 68\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.02,\n" +
            "                \"deg\": 10.5003\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 15:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409508000,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.192,\n" +
            "                \"temp_min\": 295.192,\n" +
            "                \"temp_max\": 295.192,\n" +
            "                \"pressure\": 1014.01,\n" +
            "                \"sea_level\": 1026.59,\n" +
            "                \"grnd_level\": 1014.01,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.21,\n" +
            "                \"deg\": 20.5006\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 6\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 18:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409518800,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.714,\n" +
            "                \"temp_min\": 294.714,\n" +
            "                \"temp_max\": 294.714,\n" +
            "                \"pressure\": 1014.78,\n" +
            "                \"sea_level\": 1027.27,\n" +
            "                \"grnd_level\": 1014.78,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 4.27,\n" +
            "                \"deg\": 25.5023\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 10\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-08-31 21:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409529600,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 294.823,\n" +
            "                \"temp_min\": 294.823,\n" +
            "                \"temp_max\": 294.823,\n" +
            "                \"pressure\": 1016.39,\n" +
            "                \"sea_level\": 1028.71,\n" +
            "                \"grnd_level\": 1016.39,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 501,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"moderate rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 92\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 3.36,\n" +
            "                \"deg\": 21.0004\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 4\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-01 00:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409540400,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 295.729,\n" +
            "                \"temp_min\": 295.729,\n" +
            "                \"temp_max\": 295.729,\n" +
            "                \"pressure\": 1016.05,\n" +
            "                \"sea_level\": 1028.47,\n" +
            "                \"grnd_level\": 1016.05,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 500,\n" +
            "                    \"main\": \"Rain\",\n" +
            "                    \"description\": \"light rain\",\n" +
            "                    \"icon\": \"10d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 88\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.57,\n" +
            "                \"deg\": 57.0028\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 1\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-01 03:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409551200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.994,\n" +
            "                \"temp_min\": 296.994,\n" +
            "                \"temp_max\": 296.994,\n" +
            "                \"pressure\": 1015.58,\n" +
            "                \"sea_level\": 1027.93,\n" +
            "                \"grnd_level\": 1015.58,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03d\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 48\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.01,\n" +
            "                \"deg\": 60.5016\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"d\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-01 06:00:00\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"dt\": 1409605200,\n" +
            "            \"main\": {\n" +
            "                \"temp\": 296.053,\n" +
            "                \"temp_min\": 296.053,\n" +
            "                \"temp_max\": 296.053,\n" +
            "                \"pressure\": 1016.36,\n" +
            "                \"sea_level\": 1028.89,\n" +
            "                \"grnd_level\": 1016.36,\n" +
            "                \"humidity\": 100\n" +
            "            },\n" +
            "            \"weather\": [\n" +
            "                {\n" +
            "                    \"id\": 802,\n" +
            "                    \"main\": \"Clouds\",\n" +
            "                    \"description\": \"scattered clouds\",\n" +
            "                    \"icon\": \"03n\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"clouds\": {\n" +
            "                \"all\": 44\n" +
            "            },\n" +
            "            \"wind\": {\n" +
            "                \"speed\": 2.06,\n" +
            "                \"deg\": 40.0007\n" +
            "            },\n" +
            "            \"rain\": {\n" +
            "                \"3h\": 0\n" +
            "            },\n" +
            "            \"sys\": {\n" +
            "                \"pod\": \"n\"\n" +
            "            },\n" +
            "            \"dt_txt\": \"2014-09-01 21:00:00\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
