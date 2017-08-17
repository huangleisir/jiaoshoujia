package com.jst.framework.common.util;import java.io.BufferedReader;import java.io.ByteArrayOutputStream;import java.io.IOException;import java.io.InputStream;import java.io.InputStreamReader;import java.io.PrintStream;import java.math.BigInteger;import java.security.KeyFactory;import java.security.KeyPair;import java.security.KeyPairGenerator;import java.security.NoSuchAlgorithmException;import java.security.PrivateKey;import java.security.PublicKey;import java.security.Signature;import java.security.interfaces.RSAPrivateKey;import java.security.interfaces.RSAPublicKey;import java.security.spec.InvalidKeySpecException;import java.security.spec.PKCS8EncodedKeySpec;import java.security.spec.RSAPublicKeySpec;import java.security.spec.X509EncodedKeySpec;import java.util.HashMap;import java.util.Map;import javax.crypto.Cipher;public class RSAHelper{  public static final String KEY_ALGORITHM = "RSA";  public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";  public static final int KEYBIT = 1024;  public static final int RESERVEBYTES = 11;  private static final String PUBLIC_KEY = "RSAPublicKey";  private static final String PRIVATE_KEY = "RSAPrivateKey";  private final String publickey = "";  private final String privateKey = "";  private PrivateKey localPrivKey;  private PublicKey peerPubKey;    public RSAHelper()  {    try    {      if (!"".isEmpty()) {        this.localPrivKey = getPrivateKey("");      }      if (!"".isEmpty()) {        this.peerPubKey = getPublicKey("");      }    }    catch (Exception e)    {      e.printStackTrace();    }  }    public void testMe(String publickey1)  {    if (!publickey1.isEmpty()) {      try      {        this.peerPubKey = getPublicKey(publickey1);      }      catch (Exception e)      {        e.printStackTrace();      }    }  }    public void initPrivate(String privateKey1)  {    if (!privateKey1.isEmpty()) {      try      {        this.localPrivKey = getPrivateKey(privateKey1);      }      catch (Exception e)      {        e.printStackTrace();      }    }  }    public static Map<String, Object> initKey()    throws Exception  {    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");    keyPairGen.initialize(1024);        KeyPair keyPair = keyPairGen.generateKeyPair();        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();    RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();        System.out.println(hexString(publicKey.getModulus().toByteArray()));    System.out.println(publicKey.getModulus().toString(16));        System.out.println(Base64AndZip.encode(privateKey.getEncoded()));        Map<String, Object> keyMap = new HashMap(2);    keyMap.put("RSAPublicKey", publicKey);    keyMap.put("RSAPrivateKey", privateKey);    return keyMap;  }    public static String hexString(byte[] b)  {    StringBuffer ret = new StringBuffer();    for (int i = 0; i < b.length; i++) {      ret.append(Integer.toString((b[i] & 0xFF) + 256, 16).substring(1));    }    return ret.toString();  }    public RSAPublicKey getPublicKey(InputStream in)    throws Exception  {    BufferedReader br = new BufferedReader(new InputStreamReader(in));    try    {      String readLine = null;      StringBuilder sb = new StringBuilder();      while ((readLine = br.readLine()) != null) {        if (readLine.charAt(0) != '-')        {          sb.append(readLine);          sb.append('\r');        }      }      return getPublicKey(sb.toString());    }    catch (IOException e)    {      throw new Exception("公钥数据流读取错误");    }    catch (NullPointerException e)    {      throw new Exception("公钥输入流为空");    }    finally    {      try      {        if (br != null) {          br.close();        }      }      catch (Exception e)      {        throw new Exception("关闭输入缓存流出错");      }      try      {        if (in != null) {          in.close();        }      }      catch (Exception e)      {        throw new Exception("关闭输入流出错");      }    }  }    public RSAPublicKey getPublicKey(String publicKeyStr)    throws Exception  {    try    {      byte[] buffer = Base64AndZip.decode(publicKeyStr.toCharArray());      KeyFactory keyFactory = KeyFactory.getInstance("RSA");      X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);            BigInteger n = new BigInteger(publicKeyStr, 16);      BigInteger e = new BigInteger("10001", 16);      RSAPublicKeySpec keySpec1 = new RSAPublicKeySpec(n, e);      return (RSAPublicKey)keyFactory        .generatePublic(keySpec1);    }    catch (NoSuchAlgorithmException e)    {      throw new Exception("无此算法");    }    catch (InvalidKeySpecException e)    {      throw new Exception("公钥非法");    }    catch (NullPointerException e)    {      throw new Exception("公钥数据为空");    }    catch (Exception e)    {      throw new Exception(e);    }  }    public RSAPrivateKey getPrivateKey(InputStream in)    throws Exception  {    BufferedReader br = new BufferedReader(new InputStreamReader(in));    try    {      String readLine = null;      StringBuilder sb = new StringBuilder();      while ((readLine = br.readLine()) != null) {        if (readLine.charAt(0) != '-')        {          sb.append(readLine);          sb.append('\r');        }      }      return getPrivateKey(sb.toString());    }    catch (IOException e)    {      throw new Exception("私钥数据读取错误");    }    catch (NullPointerException e)    {      throw new Exception("私钥输入流为空");    }    finally    {      try      {        if (br != null) {          br.close();        }      }      catch (Exception e)      {        throw new Exception("关闭输入缓存流出错");      }      try      {        if (in != null) {          in.close();        }      }      catch (Exception e)      {        throw new Exception("关闭输入流出错");      }    }  }    public RSAPrivateKey getPrivateKey(String privateKeyStr)    throws Exception  {    try    {      byte[] buffer = Base64AndZip.decode(privateKeyStr.toCharArray());      KeyFactory keyFactory = KeyFactory.getInstance("RSA");      PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);      return (RSAPrivateKey)keyFactory        .generatePrivate(keySpec);    }    catch (NoSuchAlgorithmException e)    {      throw new Exception("无此算法");    }    catch (InvalidKeySpecException e)    {      e.printStackTrace();      throw new Exception("私钥非法");    }    catch (NullPointerException e)    {      throw new Exception("私钥数据为空");    }  }    public byte[] encryptRSA(byte[] plainBytes, boolean useBase64Code, String charset)    throws Exception  {    String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";    int KEYBIT = 1024;    int RESERVEBYTES = 11;    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);    int decryptBlock = KEYBIT / 8;    int encryptBlock = decryptBlock - RESERVEBYTES;        int nBlock = plainBytes.length / encryptBlock;    if (plainBytes.length % encryptBlock != 0) {      nBlock++;    }    ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock *       decryptBlock);    cipher.init(1, this.peerPubKey);    for (int offset = 0; offset < plainBytes.length; offset += encryptBlock)    {      int inputLen = plainBytes.length - offset;      if (inputLen > encryptBlock) {        inputLen = encryptBlock;      }      byte[] encryptedBlock = cipher.doFinal(plainBytes, offset, inputLen);            outbuf.write(encryptedBlock);    }    if (useBase64Code) {      return new String(Base64AndZip.encode(outbuf.toByteArray())).getBytes();    }    return outbuf.toByteArray();  }    public byte[] decryptRSA(byte[] cryptedBytes, boolean useBase64Code, String charset)    throws Exception  {    String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";    byte[] data = null;    if (useBase64Code) {      data = Base64AndZip.decode(new String(cryptedBytes, charset).toCharArray());    } else {      data = cryptedBytes;    }    int KEYBIT = 1024;    int RESERVEBYTES = 11;    Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);    int decryptBlock = KEYBIT / 8;    int encryptBlock = decryptBlock - RESERVEBYTES;        int nBlock = data.length / decryptBlock;        ByteArrayOutputStream outbuf = new ByteArrayOutputStream(nBlock *       encryptBlock);    cipher.init(2, this.localPrivKey);    for (int offset = 0; offset < data.length; offset += decryptBlock)    {      int inputLen = data.length - offset;      if (inputLen > decryptBlock) {        inputLen = decryptBlock;      }      byte[] decryptedBlock = cipher.doFinal(data, offset, inputLen);            outbuf.write(decryptedBlock);    }    outbuf.flush();    outbuf.close();    return outbuf.toByteArray();  }    public byte[] signRSA(byte[] plainBytes, boolean useBase64Code, String charset)    throws Exception  {    String SIGNATURE_ALGORITHM = "SHA1withRSA";    Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);    signature.initSign(this.localPrivKey);    signature.update(plainBytes);    if (useBase64Code) {      return         new String(Base64AndZip.encode(signature.sign())).getBytes(charset);    }    return signature.sign();  }    public boolean verifyRSA(byte[] plainBytes, byte[] signBytes, boolean useBase64Code, String charset)    throws Exception  {    boolean isValid = false;    try    {      String SIGNATURE_ALGORITHM = "SHA1withRSA";      Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);      signature.initVerify(this.peerPubKey);      signature.update(plainBytes);      if (useBase64Code) {        isValid = signature.verify(Base64AndZip.decode(new String(          signBytes, charset).toCharArray()));      } else {        isValid = signature.verify(signBytes);      }    }    catch (Exception e)    {      e.printStackTrace();    }    return isValid;  }    public static void main(String[] args)    throws Exception  {    RSAHelper r = new RSAHelper();        String s = "{\"txncode\":\"charge\",\"cardno\":\"2253123456781234\"}";    String sign = "8501C57883A26FFDA679403816E31BC3B455C5E04BDE47711BAF50A926151BEB0BE895E2563C1BE205D5E2054A1321FFF5A09D39677A4EE7A856AB1FD74F0A38641A868C5C7A781F89D2496D978DDF6B63E44110C52D58E5D1106271A75083A4E948D19B7BB9BE0040D85536FDAC1649015C2049586590CF878DFE110507E87A";    BigInteger signature = new BigInteger(sign, 16);  }}