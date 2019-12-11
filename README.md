# Processing ColorObject

Library for operating Processing color datatype

## Example

```java
import midnightSuyama.ColorObject;

ColorObject col = new ColorObject(color(0));

void setup() {
  col.r(255);
}

void draw() {
  background( col.incHue(0.01f) );

  println( "RGBA:", col.r(), col.g(), col.b(), col.a() );
  println( "HSB:", col.hue(), col.saturation(), col.brightness() );
}
```

## Installation

Download [package](https://github.com/midnightSuyama/ColorObject/releases), unzip and put the extracted ColorObject folder into the Processing libraries folder. Restart Processing and in the Sketch -> Import Library menu you should see ColorObject in the contributed list.

## Usage

### Constructor

```java
import midnightSuyama.ColorObject;

ColorObject col = new ColorObject(color(12, 34, 56));
//ColorObject col = new ColorObject(12, 34, 56);
//ColorObject col = new ColorObject(12, 34, 56, 255);
```

### RGBA \[0-255\]

#### Get

```java
int red   = col.r();
int green = col.g();
int blue  = col.b();
int alpha = col.a();

color rgb  = col.rgb();
color rgba = col.rgba();
```

#### Set

```java
col.r(255);
col.g(255);
col.b(255);
col.a(255);

col.rgb(255, 255, 255);
col.rgba(255, 255, 255, 255);
```

#### Increment & Decrement

```java
col.incR(1);
col.incG(1);
col.incB(1);
col.incA(1);

col.decR(1);
col.decG(1);
col.decB(1);
col.decA(1);
```

### HSB \[0f-1.0f\]

#### Get

```java
float hue        = col.hue();
float saturation = col.saturation();
float brightness = col.brightness();

float[] hsb = col.hsb();
```

#### Set

```java
col.hue(0f);
col.saturation(1.0f);
col.brightness(1.0f);

col.hsb(0f, 1.0f, 1.0f);
```

#### Increment & Decrement

```java
col.incHue(0.01f);
col.incSaturation(0.01f);
col.incBrightness(0.01f);

col.decHue(0.01f);
col.decSaturation(0.01f);
col.decBrightness(0.01f);
```
