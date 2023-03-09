
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNReactNativeMinimizerSpec.h"

@interface ReactNativeMinimizer : NSObject <NativeReactNativeMinimizerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ReactNativeMinimizer : NSObject <RCTBridgeModule>
#endif

@end
