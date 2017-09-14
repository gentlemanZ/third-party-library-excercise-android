package io.intrepid.thirdpartylibraryexcercise;

import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;

class MainPresenter implements MainContract.Presenter, GetRandomCatUrlTask.Callback {

    private static final String CAT_URL = "http://www.random.cat/meow";

    private MainContract.View view;

    @Override
    public void bindView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        this.view = null;
    }

    @Override
    public void onNewCatButtonClick() {
        view.showLoadingIndicator();
        GetRandomCatUrlTask getRandomCatUrlTask = new GetRandomCatUrlTask();
        getRandomCatUrlTask.setCallback(this);
        getRandomCatUrlTask.execute(CAT_URL);


    }

    @Override
    public void onUrlResult(String randomCatUrl) {
        view.loadImageFromUrl(randomCatUrl);
    }
}
