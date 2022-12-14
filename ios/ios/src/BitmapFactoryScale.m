//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSShutterBugPlugin\src\main\java\com\applidium\shutterbug\utils\BitmapFactoryScale.java
//

#include "Bitmap.h"
#include "BitmapFactory.h"
#include "BitmapFactoryScale.h"
#include "DownloadRequest.h"
#include "J2ObjC_source.h"
#include "java/io/InputStream.h"
#include "java/lang/OutOfMemoryError.h"


@interface APBitmapFactoryScale_InputStreamGenerator : NSObject

@end

@implementation APBitmapFactoryScale

J2OBJC_IGNORE_DESIGNATED_BEGIN
- (instancetype)init {
  APBitmapFactoryScale_init(self);
  return self;
}
J2OBJC_IGNORE_DESIGNATED_END

+ (id<ADBitmap>)decodeSampledBitmapFromStreamWithAPBitmapFactoryScale_InputStreamGenerator:(id<APBitmapFactoryScale_InputStreamGenerator>)generator
                                                                     withAPDownloadRequest:(APDownloadRequest *)request {
  return APBitmapFactoryScale_decodeSampledBitmapFromStreamWithAPBitmapFactoryScale_InputStreamGenerator_withAPDownloadRequest_(generator, request);
}

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, NULL, 0x1, -1, -1, -1, -1, -1, -1 },
    { NULL, "LADBitmap;", 0x9, 0, 1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(init);
  methods[1].selector = @selector(decodeSampledBitmapFromStreamWithAPBitmapFactoryScale_InputStreamGenerator:withAPDownloadRequest:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "decodeSampledBitmapFromStream", "LAPBitmapFactoryScale_InputStreamGenerator;LAPDownloadRequest;", "LAPBitmapFactoryScale_InputStreamGenerator;" };
  static const J2ObjcClassInfo _APBitmapFactoryScale = { "BitmapFactoryScale", "com.applidium.shutterbug.utils", ptrTable, methods, NULL, 7, 0x1, 2, 0, -1, 2, -1, -1, -1 };
  return &_APBitmapFactoryScale;
}

@end

void APBitmapFactoryScale_init(APBitmapFactoryScale *self) {
  NSObject_init(self);
}

APBitmapFactoryScale *new_APBitmapFactoryScale_init() {
  J2OBJC_NEW_IMPL(APBitmapFactoryScale, init)
}

APBitmapFactoryScale *create_APBitmapFactoryScale_init() {
  J2OBJC_CREATE_IMPL(APBitmapFactoryScale, init)
}

id<ADBitmap> APBitmapFactoryScale_decodeSampledBitmapFromStreamWithAPBitmapFactoryScale_InputStreamGenerator_withAPDownloadRequest_(id<APBitmapFactoryScale_InputStreamGenerator> generator, APDownloadRequest *request) {
  APBitmapFactoryScale_initialize();
  if (generator == nil || request == nil) {
    return nil;
  }
  @try {
    ADBitmapFactory_Options *options = new_ADBitmapFactory_Options_init();
    options->inJustDecodeBounds_ = true;
    (void) ADBitmapFactory_decodeStreamWithJavaIoInputStream_withId_withADBitmapFactory_Options_([generator getStream], nil, options);
    options->inSampleSize_ = [request getSampleSizeWithADBitmapFactory_Options:options];
    options->inJustDecodeBounds_ = false;
    return ADBitmapFactory_decodeStreamWithJavaIoInputStream_withId_withADBitmapFactory_Options_([generator getStream], nil, options);
  }
  @catch (JavaLangOutOfMemoryError *e) {
    [e printStackTrace];
    return nil;
  }
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(APBitmapFactoryScale)

@implementation APBitmapFactoryScale_InputStreamGenerator

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "LJavaIoInputStream;", 0x401, -1, -1, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(getStream);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "LAPBitmapFactoryScale;" };
  static const J2ObjcClassInfo _APBitmapFactoryScale_InputStreamGenerator = { "InputStreamGenerator", "com.applidium.shutterbug.utils", ptrTable, methods, NULL, 7, 0x609, 1, 0, 0, -1, -1, -1, -1 };
  return &_APBitmapFactoryScale_InputStreamGenerator;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(APBitmapFactoryScale_InputStreamGenerator)
