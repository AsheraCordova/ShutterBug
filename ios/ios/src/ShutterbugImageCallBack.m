//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: D:\Java\git\core-ios-widgets\IOSShutterBugPlugin\src\main\java\com\applidium\shutterbug\ShutterbugImageCallBack.java
//

#include "J2ObjC_source.h"
#include "ShutterbugImageCallBack.h"


@interface APShutterbugImageCallBack : NSObject

@end

@implementation APShutterbugImageCallBack

+ (const J2ObjcClassInfo *)__metadata {
  static J2ObjcMethodInfo methods[] = {
    { NULL, "V", 0x401, 0, 1, -1, -1, -1, -1 },
    { NULL, "V", 0x401, 2, 3, -1, -1, -1, -1 },
    { NULL, "V", 0x401, 4, 5, -1, -1, -1, -1 },
  };
  #pragma clang diagnostic push
  #pragma clang diagnostic ignored "-Wobjc-multiple-method-names"
  #pragma clang diagnostic ignored "-Wundeclared-selector"
  methods[0].selector = @selector(setImageDrawableWithADDrawable:);
  methods[1].selector = @selector(setImageBitmapWithADBitmap:);
  methods[2].selector = @selector(showErrorWithNSString:);
  #pragma clang diagnostic pop
  static const void *ptrTable[] = { "setImageDrawable", "LADDrawable;", "setImageBitmap", "LADBitmap;", "showError", "LNSString;" };
  static const J2ObjcClassInfo _APShutterbugImageCallBack = { "ShutterbugImageCallBack", "com.applidium.shutterbug", ptrTable, methods, NULL, 7, 0x609, 3, 0, -1, -1, -1, -1, -1 };
  return &_APShutterbugImageCallBack;
}

@end

J2OBJC_INTERFACE_TYPE_LITERAL_SOURCE(APShutterbugImageCallBack)
