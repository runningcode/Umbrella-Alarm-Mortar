package com.osacky.umbrella.mortar;

import android.content.Intent;

public interface ActivityResultInterface {
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
