package ru.mirea.fedulovama.mireaproject;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraFragment extends Fragment {
    private	static	final	int	REQUEST_CODE_PERMISSION	=	100;
    private	boolean	isWork	=	false;
    private Uri imageUri;

    private ImageView image;

    public CameraFragment() {
        // Required empty public constructor
    }
    public static CameraFragment newInstance(String param1, String param2) { return new CameraFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);
        image = view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int	cameraPermissionStatus	=	ContextCompat.checkSelfPermission(requireContext(),	android.Manifest.permission.CAMERA);
        int	storagePermissionStatus	=	ContextCompat.checkSelfPermission(requireContext(),	Manifest.permission.READ_MEDIA_IMAGES);
        if	(cameraPermissionStatus	==	PackageManager.PERMISSION_GRANTED	&&	storagePermissionStatus
                ==	PackageManager.PERMISSION_GRANTED)	{
            isWork	=	true;
        }	else if (storagePermissionStatus !=	PackageManager.PERMISSION_GRANTED)	{
            String[] permissions = {Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO,
                    Manifest.permission.READ_MEDIA_AUDIO};
            ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_CODE_PERMISSION);
        }
        else{
            ActivityCompat.requestPermissions(requireActivity(),	new	String[]	{android.Manifest.permission.CAMERA,
                    Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO,
                    Manifest.permission.READ_MEDIA_AUDIO},	REQUEST_CODE_PERMISSION);
        }
        ActivityResultCallback<ActivityResult> callback	=	new	ActivityResultCallback<ActivityResult>()	{
            @Override
            public	void	onActivityResult(ActivityResult	result)	{
                if	(result.getResultCode()	==	Activity.RESULT_OK)	{
                    image.setImageURI(imageUri);
                }
            }
        };
        ActivityResultLauncher<Intent> cameraActivityResultLauncher	=		registerForActivityResult(
                new	ActivityResultContracts.StartActivityForResult(),
                callback);
        image.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View	v)	{
                Log.d("MainActivity", "imageView clicked");
                Intent	cameraIntent	=	new	Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if	(isWork)	{
                    Log.d("MainActivity", "TRUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    try	{

                        File photoFile	=	createImageFile();
                        String	authorities	=	getActivity().getApplicationContext().getPackageName()	+	".fileprovider";
                        imageUri	=	FileProvider.getUriForFile(requireActivity(),	authorities,	photoFile);
                        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,	imageUri);
                        cameraActivityResultLauncher.launch(cameraIntent);
                    }	catch	(IOException e)	{
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private File createImageFile()	throws	IOException	{
        String	timeStamp	=	new SimpleDateFormat("yyyyMMdd_HHmmss",	Locale.ENGLISH).format(new Date());
        String	imageFileName	=	"IMAGE_"	+	timeStamp	+	"_";
        File	storageDirectory	=	getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return	File.createTempFile(imageFileName,	".jpg",	storageDirectory);
    }
}