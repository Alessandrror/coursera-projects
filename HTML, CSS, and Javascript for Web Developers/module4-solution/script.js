(function (window) {
var names = ["Yaakov", "John", "Jen", "Jason", "Paul", "Frank", "Larry", "Paula", "Laura", "Jim"];

for (var i = 0; i < names.length; i++) {

  var props = names[i].charAt(0).toLowerCase();
  if (props === 'j') {
    byeSpeaker.speak(names[i]);
  } 
  
  else {
    helloSpeaker.speak(names[i]);
  }
}
})(window);

// This could be other way to get the same

// (function (window) {
//   var names = ["Yaakov", "John", "Jen", "Jason", "Paul", "Frank", "Larry", "Paula", "Laura", "Jim"];
  
//   for (var i in names) {
  
//     var props = names[i].charAt(0).toLowerCase();
//     if (props === 'j') {
//       byeSpeaker.speak(names[i]);
//     } 
    
//     else {
//       helloSpeaker.speak(names[i]);
//     }
//   }
//   })(window);
