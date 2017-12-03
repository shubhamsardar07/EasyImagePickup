package dsardy.in.easyimagepickup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements EasyImagePickUP.ImagePickerListener {

    EasyImagePickUP easyImagePickUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyImagePickUP = new EasyImagePickUP(this);
    }

    @Override
    public void onPicked(int from, String filename, Bitmap file, Uri uri) {

        Log.d("Image Picked: ",filename);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        easyImagePickUP.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        easyImagePickUP.request_permission_result(requestCode,permissions,grantResults);
    }

    public void pickup(View view) {
        easyImagePickUP.imagepicker(1);
    }
}
