import midnightSuyama.ColorObject;

ColorObject col = new ColorObject(color(12, 34, 56));
//ColorObject col = new ColorObject(12, 34, 56);
//ColorObject col = new ColorObject(12, 34, 56, 255);

void draw() {
  // Get Processing color datatype
  background( col.rgba() );
  //background( col.rgb() );

  // Get RGBA & HSB
  println( "RGBA:", col.r(), col.g(), col.b(), col.a() );
  println( "HSB:", col.hue(), col.saturation(), col.brightness() );
  //printArray( col.hsb() );

  // Set RGBA [0-255]
  //col.r(255);
  //col.g(255);
  //col.b(255);
  //col.a(255);
  //col.rgb(255, 255, 255);
  //col.rgba(255, 255, 255, 255);

  // Set HSB [0f-1.0f]
  //col.hue(0f);
  //col.saturation(1.0f);
  //col.brightness(1.0f);
  //col.hsb(0f, 1.0f, 1.0f);

  // Increment & Decrement RGBA
  //col.incR(1);
  //col.incG(1);
  //col.incB(1);
  //col.incA(1);
  //col.decR(1);
  //col.decG(1);
  //col.decB(1);
  //col.decA(1);

  // Increment & Decrement HSB
  col.incHue(0.01f);
  col.incSaturation(0.01f);
  col.incBrightness(0.01f);
  //col.decHue(0.01f);
  //col.decSaturation(0.01f);
  //col.decBrightness(0.01f);
}
