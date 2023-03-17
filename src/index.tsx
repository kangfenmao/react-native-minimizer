let Minimizer = {
  minimize: () => {},
  goBack: () => {},
  exit: () => {},
};

if (!process.env.ELECTRON) {
  const { NativeModules, Platform } = require('react-native');

  const LINKING_ERROR =
    `The package '@kangfenmao/react-native-minimizer' doesn't seem to be linked. Make sure: \n\n` +
    Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
    '- You rebuilt the app after installing the package\n' +
    '- You are not using Expo Go\n';

  const ReactNativeMinimizer = NativeModules.ReactNativeMinimizer
    ? NativeModules.ReactNativeMinimizer
    : new Proxy(
        {},
        {
          get() {
            throw new Error(LINKING_ERROR);
          },
        }
      );

  Minimizer = ReactNativeMinimizer;
}

export default Minimizer;
