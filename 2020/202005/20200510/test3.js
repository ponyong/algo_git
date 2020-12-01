function solution(arr) {
  var map = new Map();
  for (var i = 0; i < arr.length; i++) {
    var temp = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

    var temp_s = arr[i].toString();
    for (var j = 0; j < temp_s.length; j++) {
      temp[temp_s.charAt(j) - "0"]++;
    }
    var temp_string = "";
    for (var k = 0; k < 10; k++) {
      if (temp[k] > 0) {
        for (var l = 0; l < temp[k]; l++) {
          temp_string += k;
        }
      }
    }
    if (map.get(temp_string) == null) {
      map.set(temp_string, 1);
    } else {
      map.set(temp_string, map.get(temp_string) + 1);
    }
  }
  return map.size;
}

var sol = [123, 234, 213, 432, 234, 1234, 2341, 12345, 324];

solution(sol);
