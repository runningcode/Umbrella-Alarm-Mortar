package rx;

import retrofit.RetrofitError;
import timber.log.Timber;

import static retrofit.RetrofitError.*;
import static retrofit.RetrofitError.Kind.CONVERSION;
import static retrofit.RetrofitError.Kind.HTTP;
import static retrofit.RetrofitError.Kind.NETWORK;
import static retrofit.RetrofitError.Kind.UNEXPECTED;

public abstract class RetrofitObserver<T> implements Observer<T> {
    @Override public void onCompleted() {
    }

    @Override public void onError(Throwable e) {
        if (e instanceof RetrofitError) {
            RetrofitError retrofitError = (RetrofitError) e;
            if (retrofitError.getKind().equals(UNEXPECTED)) {
                onUnexpectedError(e);
            } else {
                onRetrofitError(retrofitError);
            }
        } else {
            onUnexpectedError(e);
        }
    }

    protected abstract void onRetrofitError(RetrofitError retrofitError);

    private void onUnexpectedError(Throwable t) {
        Timber.e(t, "An unexpected error occurred with the request");
        throw new RuntimeException(t);
    }
}
