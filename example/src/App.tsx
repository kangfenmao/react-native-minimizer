import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { goBack } from '@kangfenmao/react-native-minimizer';

export default function App() {
  return (
    <View style={styles.container}>
      <Text onPress={goBack}>GoBack</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
