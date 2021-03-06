/*package com.jst.framework.common.util;

import com.jst.prodution.util.ILogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.util.Assert;

public class FastDfsUtils
{
  private static ILogger logger = new ILogger("jst-oms", FastDfsUtils.class);
  private static TrackerClient trackerClient = null;
  
  static
  {
    try
    {
      ClientGlobal.init("config/fdfs_client.conf");
      trackerClient = new TrackerClient();
    }
    catch (Exception e)
    {
      logger.error("加载文件异常：", e);
      e.printStackTrace();
    }
  }
  
  private static byte[] getFileBuffer(InputStream inStream, long fileLength)
    throws IOException
  {
    byte[] buffer = new byte[262144];
    byte[] fileBuffer = new byte[(int)fileLength];
    int count = 0;
    int length = 0;
    while ((length = inStream.read(buffer)) != -1)
    {
      for (int i = 0; i < length; i++) {
        fileBuffer[(count + i)] = buffer[i];
      }
      count += length;
    }
    return fileBuffer;
  }
  
  public static String uploadFile(File file, String uploadFileName, long fileLength)
    throws Exception
  {
    byte[] fileBuff = getFileBuffer(new FileInputStream(file), fileLength);
    String fileExtName = "";
    if (uploadFileName.contains("."))
    {
      fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
    }
    else
    {
      logger.error("Fail to upload file, because the format of filename is illegal.");
      return null;
    }
    TrackerServer tracker = null;
    
    NameValuePair[] metaList = getFileNameValuePair(uploadFileName, fileExtName, Long.valueOf(fileLength));
    try
    {
      tracker = trackerClient.getConnection();
      StorageClient1 sClient = new StorageClient1(tracker, null);
      String filePath = sClient.upload_file1(fileBuff, fileExtName, metaList);
      return filePath;
    }
    finally
    {
      if (tracker != null) {
        try
        {
          tracker.close();
        }
        catch (Exception e)
        {
          logger.error("加载文件异常：", e);
          e.printStackTrace();
        }
      }
    }
  }
  
  public static NameValuePair[] getFileNameValuePair(String uploadFileName, String fileExtName, Long fileLength)
  {
    NameValuePair[] metaList = new NameValuePair[3];
    metaList[0] = new NameValuePair("fileName", uploadFileName);
    metaList[1] = new NameValuePair("fileExtName", fileExtName);
    metaList[2] = new NameValuePair("fileLength", String.valueOf(fileLength));
    return metaList;
  }
  
  public static String upload(byte[] file, String uploadFileName, long fileLength)
    throws Exception
  {
    if ((file == null) || (file.length == 0)) {
      throw new Exception("上传文件不能为空");
    }
    Assert.notNull(uploadFileName);
    TrackerServer tracker = null;
    String fileExtName = "";
    if (uploadFileName.contains("."))
    {
      fileExtName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);
    }
    else
    {
      logger.error("Fail to upload file, because the format of filename is illegal.");
      return null;
    }
    NameValuePair[] metaList = getFileNameValuePair(uploadFileName, fileExtName, Long.valueOf(fileLength));
    try
    {
      tracker = trackerClient.getConnection();
      StorageClient1 sClient = new StorageClient1(tracker, null);
      


      String filePath = sClient.upload_file1(file, fileExtName, metaList);
      return filePath;
    }
    finally
    {
      if (tracker != null) {
        try
        {
          tracker.close();
        }
        catch (Exception e)
        {
          logger.error("加载文件异常：", e);
          e.printStackTrace();
        }
      }
    }
  }
  
  public static byte[] download(String url)
    throws Exception
  {
    TrackerServer tracker = null;
    try
    {
      tracker = trackerClient.getConnection();
      StorageClient1 sClient = new StorageClient1(tracker, null);
      byte[] file = sClient.download_file1(url);
      return file;
    }
    finally
    {
      try
      {
        if (tracker != null) {
          tracker.close();
        }
      }
      catch (Exception e)
      {
        logger.error("加载文件异常：", e);
        e.printStackTrace();
      }
    }
  }
  
  public static int delete(String url)
    throws Exception
  {
    TrackerServer tracker = null;
    try
    {
      tracker = trackerClient.getConnection();
      StorageClient1 client = new StorageClient1(tracker, null);
      return client.delete_file1(url);
    }
    finally
    {
      try
      {
        if (tracker != null) {
          tracker.close();
        }
      }
      catch (Exception e)
      {
        logger.error("加载文件异常：", e);
        e.printStackTrace();
      }
    }
  }
}
*/