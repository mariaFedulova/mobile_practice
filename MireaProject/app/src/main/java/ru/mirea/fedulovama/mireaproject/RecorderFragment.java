package ru.mirea.fedulovama.mireaproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class RecorderFragment extends Fragment {
    private	static	final	int	REQUEST_CODE_PERMISSION	=	200;
    private	boolean	isWork;
    private	final	String	TAG	=	MainActivity.class.getSimpleName();
    private	String	fileName	=	null;
    private Button recordButton	=	null;
    private	Button	playButton	=	null;
    private MediaRecorder recorder	=	null;
    private MediaPlayer player	=	null;
    boolean	isStartRecording	=	true;
    boolean	isStartPlaying	=	true;
    public RecorderFragment() {
    }
    public static RecorderFragment newInstance(String param1, String param2) {
        return new RecorderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recorder, container, false);
        recordButton	=	view.findViewById(R.id.buttonStart);
        playButton	=	view.findViewById(R.id.buttonPlay);
        playButton.setEnabled(false);
        fileName	=	(new File(getActivity().getExternalFilesDir(Environment.DIRECTORY_MUSIC),
                "/audiorecordtest.3gp")).getAbsolutePath();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        int	audioRecordPermissionStatus	=	ContextCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.RECORD_AUDIO);
        int	storagePermissionStatus	=	ContextCompat.checkSelfPermission(requireContext(),	Manifest.permission.
                RECORD_AUDIO);
        if	(audioRecordPermissionStatus	==	PackageManager.PERMISSION_GRANTED	&&	storagePermissionStatus
                ==	PackageManager.PERMISSION_GRANTED)	{
            isWork	=	true;
        }
        else{
            ActivityCompat.requestPermissions(requireActivity(),	new	String[]	{Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_MEDIA_AUDIO},	REQUEST_CODE_PERMISSION);
        }
        recordButton.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void	onClick(View v)	{
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