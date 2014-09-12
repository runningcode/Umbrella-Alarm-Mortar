package rx;

import retrofit.RetrofitError;
import timber.log.Timber;

public abstract class RetrofitObserver<T> implements Observer<T> {
    @Override public void onCompleted() {
    }

    @Override public void onError(Throwable e) {
        if (e instanceof RetrofitError) {
            onRetrofitError((RetrofitError) e);
        } else {
            Timber.e(e, "A non-retrofit error occurred with the request");
            throw new RuntimeException(e);
        }
    }

    public abstract void onRetrofitError(RetrofitError e);
}
