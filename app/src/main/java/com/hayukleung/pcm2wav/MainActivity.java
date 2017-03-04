package com.hayukleung.pcm2wav;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class MainActivity extends ListActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    try {
      RandomAccessFile randomAccessFile = Utils.fopen(getExternalCacheDir() + "/002.wav");
      // File file = new File("file:///android_asset/壹品牛肉01.pcm");
      InputStream inputStream = getClass().getResourceAsStream("/assets/壹品牛肉02.pcm");
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      int ch;
      while ((ch = inputStream.read()) != -1) {
        byteArrayOutputStream.write(ch);
      }
      byte data[] = byteArrayOutputStream.toByteArray();
      byteArrayOutputStream.close();
      Utils.fwrite(randomAccessFile, data, 0, data.length);
      Utils.fclose(randomAccessFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
