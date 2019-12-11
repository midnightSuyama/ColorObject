package midnightSuyama;

import java.awt.Color;

public class ColorObject
{
  // Processing color datatype 32 bits (AAAAAAAA RRRRRRRR GGGGGGGG BBBBBBBB)
  protected int col = 0xff000000;

  //----------------------------------------------------------------------------
  // Constructor
  //----------------------------------------------------------------------------
  public ColorObject(int col) {
    this.col = col;
  }

  public ColorObject(int r, int g, int b) {
    rgb(r, g, b);
  }

  public ColorObject(int r, int g, int b, int a) {
    rgba(r, g, b, a);
  }

  //----------------------------------------------------------------------------
  // Getter
  //----------------------------------------------------------------------------
  public int a()    { return col >> 24 & 0xff; }
  public int r()    { return col >> 16 & 0xff; }
  public int g()    { return col >>  8 & 0xff; }
  public int b()    { return col       & 0xff; }
  public int rgb()  { return col | 0xff000000; }
  public int rgba() { return col; }

  public float   hue()        { convertHsb(); return cacheHsbValue[0]; }
  public float   saturation() { convertHsb(); return cacheHsbValue[1]; }
  public float   brightness() { convertHsb(); return cacheHsbValue[2]; }
  public float[] hsb()        { convertHsb(); return cacheHsbValue; }

  protected int cacheHsbKey;
  protected float[] cacheHsbValue = new float[3];
  protected void convertHsb() {
    int key = rgb();
    if (key != cacheHsbKey) {
      Color.RGBtoHSB(r(), g(), b(), cacheHsbValue);
    }
    cacheHsbKey = key;
  }

  //----------------------------------------------------------------------------
  // Setter
  //----------------------------------------------------------------------------
  public int a(int a)                         { return col = (col & 0x00ffffff) | (i8(a) << 24); }
  public int r(int r)                         { return col = (col & 0xff00ffff) | (i8(r) << 16); }
  public int g(int g)                         { return col = (col & 0xffff00ff) | (i8(g) <<  8); }
  public int b(int b)                         { return col = (col & 0xffffff00) |  i8(b); }
  public int rgb(int r, int g, int b)         { return col = (col & 0xff000000) | (i8(r) << 16) | (i8(g) << 8) | i8(b); }
  public int rgba(int r, int g, int b, int a) { return col = (i8(a) << 24)      | (i8(r) << 16) | (i8(g) << 8) | i8(b); }

  public int hue(float h)                   { return col = (col & 0xff000000) | (Color.HSBtoRGB(    h, saturation(), brightness()) & 0x00ffffff); }
  public int saturation(float s)            { return col = (col & 0xff000000) | (Color.HSBtoRGB(hue(),        fn(s), brightness()) & 0x00ffffff); }
  public int brightness(float b)            { return col = (col & 0xff000000) | (Color.HSBtoRGB(hue(), saturation(),        fn(b)) & 0x00ffffff); }
  public int hsb(float h, float s, float b) { return col = (col & 0xff000000) | (Color.HSBtoRGB(    h,        fn(s),        fn(b)) & 0x00ffffff); }

  protected int i8(int i) {
    if (i > 0xff) i = 0xff; else if (i < 0x00) i = 0;
    return i;
  }

  protected float fn(float f) {
    if (f > 1.0f) f = 1.0f; else if (f < 0f) f = 0f;
    return f;
  }

  //----------------------------------------------------------------------------
  // Increment & Decrement
  //----------------------------------------------------------------------------
  public int incA(int a) { return col = a(a() + a); }
  public int decA(int a) { return col = a(a() - a); }
  public int incR(int r) { return col = r(r() + r); }
  public int decR(int r) { return col = r(r() - r); }
  public int incG(int g) { return col = g(g() + g); }
  public int decG(int g) { return col = g(g() - g); }
  public int incB(int b) { return col = b(b() + b); }
  public int decB(int b) { return col = b(b() - b); }

  public int incHue(float h) { return col = hue(hue() + h); }
  public int decHue(float h) { return col = hue(hue() - h); }
  public int incSaturation(float s) { return col = saturation(saturation() + s); }
  public int decSaturation(float s) { return col = saturation(saturation() - s); }
  public int incBrightness(float b) { return col = brightness(brightness() + b); }
  public int decBrightness(float b) { return col = brightness(brightness() - b); }
}
