package ru.mirea.fedulovama.audiorecord;

import ru.mirea.fedulovama.audiorecord.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import	androidx.annotation.NonNull;
import	androidx.core.app.ActivityCompat;
import	android.Manifest;
import	android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private	static	final	int	REQUEST_CODE_PERMISSION	=	200;
    private	boolean	isWork;
    private	final	String	TAG	=	MainActivity.class.getSimpleName();
    private		ActivityMainBinding	binding;
    private	String	fileName	=	null;
    private Button recordButton	=	null;
    private	Button	playButton	=	null;
    private MediaRecorder recorder	=	null;
    private MediaPlayer player	=	null;
    boolean	isStartRecording	=	true;
    boolean	isStartPlaying	=	true;
    @Override
    protected	void	onCreate(Bundle	savedInstanceState)	{
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recordButton	=	binding.buttonStart;
        playButton	=	binding.buttonPlay;
        playButton.setEnabled(false);
        fileName	=	(new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC),
                "/audiorecordtest.3gp")).getAbsolutePath();
        int	audioRecordPermissionStatus	=	ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);
        int	storagePermissionStatus	=	ContextCompat.checkSelfPermission(this,	Manifest.permission.
                RECORD_AUDIO);
        if	(audioRecordPermissionStatus	==	PackageManager.PERMISSION_GRANTED	&&	storagePermissionStatus
                ==	PackageManager.PERMISSION_GRANTED)	{
            isWork	=	true;
        }
        else{
            ActivityCompat.requestPermissions(this,	new	String[]	{Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_MEDIA_AUDIO},	REQUEST_CODE_PERMISSION);
        }
        recordButton.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View	v)	{
                if	(isStartRecording){
                    recordButton.setText("Остановить запись. №26, БСБО-10-21");
                    playButton.setEnabled(false);
                    startRecording();
                }
                else{
                    recordButton.setText("Начать запись. №26, БСБО-10-21");
                    playButton.setEnabled(true);
                    stopRecording();
                }
                isStartRecording	=	!isStartRecording;
            }
        });
        playButton.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View	v) {
                if (isStartPlaying) {
                    playButton.setText("Выключить");
                    recordButton.setEnabled(false);
                    startPlaying();
                } else {
                    playButton.setText("Воспроизвести");
                    recordButton.setEnabled(true);
                    stopPlaying();
                }
                isStartPlaying = !isStartPlaying;
            }
        });
    }
    private	void	startRecording()	{
        recorder	=	new	MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try	{
            recorder.prepare();
        }	catch	(IOException e)	{
            Log.e(TAG,	"prepare()	failed");
        }
        recorder.start();
    }
    private	void	stopRecording()	{
        recorder.stop();
        recorder.release();
        recorder	=	null;
    }
    private	void	startPlaying()	{
        player	=	new	MediaPlayer();
        try	{
            player.setDataSource(fileName);
            player.prepare();
            player.start();
        }	catch	(IOException	e)	{
            Log.e(TAG,	"prepare()	failed");
        }
    }
    private	void	stopPlaying()	{
        player.release();
        player	=	null;
    }
}
