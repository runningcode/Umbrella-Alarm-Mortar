package rx;

import android.support.annotation.Nullable;

import rx.Observable;
import rx.observables.ConnectableObservable;

public class RxUtils {

    private RxUtils() {}

    public static <T> Observable<T> cacheAndReplay(Observable<T> observable) {
        ConnectableObservable<T> replay = observable.replay(1);
        replay.connect();
        return replay;
    }

    public static <T> Observable<T> wrap(@Nullable T object) {
        if (object == null) {
            return Observable.empty();
        } else {
            return Observable.just(object);
        }
    }
}

