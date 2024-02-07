import 'package:flutter/material.dart';

void main() {
  var app = MaterialApp(
    debugShowCheckedModeBanner: false,
    title: "My Cs App",
    home: Scaffold(
      appBar: AppBar(
        title: Text("สร้างซิกแพค"),
      ),
    ),
    theme: ThemeData(primarySwatch: Colors.orange),
  );

  runApp(app);
}
