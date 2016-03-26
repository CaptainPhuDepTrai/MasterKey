package com.phucute.masterkey;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.whyal.hackathondemo.R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class UseCamera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SurfaceView cameraView = (SurfaceView) findViewById(R.id.camera_view);
        final TextView barcodeInfo = (TextView) findViewById(R.id.code_info);

        final Button opencloseBtn = (Button) findViewById(R.id.openclose_button);
        final TextView doorStatus = (TextView) findViewById(R.id.door_status);
        final Button saveButton = (Button) findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.array.add(new Door(barcodeInfo.getText().toString()));
                changed();
            }
        });

        opencloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (opencloseBtn.getText().equals("OPEN")) {
                    opencloseBtn.setText("CLOSE");
                    doorStatus.setText("It is opened!");
                } else {
                    opencloseBtn.setText("OPEN");
                    doorStatus.setText("It is closed!");
                }
            }
        });

        BarcodeDetector barcodeDetector =
                new BarcodeDetector.Builder(this)
                        .setBarcodeFormats(Barcode.QR_CODE)
                        .build();

        final CameraSource cameraSource = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 720)
                .build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(UseCamera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(cameraView.getHolder());
                } catch (java.io.IOException ie) {
                    Log.e("CAMERA SOURCE", ie.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });


        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                if (barcodes.size() != 0) {
                    barcodeInfo.post(new Runnable() {    // Use the post method of the TextView
                        public void run() {
                            barcodeInfo.setText(    // Update the TextView
                                    barcodes.valueAt(0).displayValue
                            );
                        }
                    });
                }
            }
        });
    }
    public void changed(){
        Intent intent = new Intent(this,MainMenu.class);
        startActivity(intent);
    }

}






























//import android.app.Activity;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//
//public class UseCamera extends Activity {
//    private static final int REQUEST_IMAGE_CAPTURE = 1;
//     ImageView imageView;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.camera2);
//        this.imageView = (ImageView)this.findViewById(R.id.imageView1);
//        Button photoButton = (Button) this.findViewById(R.id.button1);
//        if(!hasCamera()){
//            photoButton.setEnabled(false);
//        }
//        photoButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//               launchCamera(v);
//            }
//        });
//    }
//    private boolean hasCamera(){
//        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
//    }
//
//    public void launchCamera (View view){
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bitmap photo = (Bitmap) data.getExtras().get("data");
//            imageView.setImageBitmap(photo);
//        }
//    }
//}