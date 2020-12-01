function solution(arr) {
  var sol = [];
  var sol_cnt = 1;
  for (var l = 0; l < arr.length; l++) {
    sol.push(arr[l]);
  }
  while (sol.length != 1) {
    var temp = [];
    var cnt = 1;
    var x = sol[0];
    for (var i = 1; i < sol.length; i++) {
      if (x == sol[i]) {
        cnt++;
      } else {
        temp.push(cnt);
        cnt = 1;
        x = sol[i];
      }
    }
    temp.push(cnt);
    console.log(temp);
    sol_cnt++;
    if (temp.length != 0) {
      sol = [];
      for (var k = 0; k < temp.length; k++) {
        sol.push(temp[k]);
      }
    }
  }
  return sol_cnt;
}

// var sol = [1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3];
// var sol = [1, 2, 3];
// var sol = [2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2];
var sol = [2];
solution(sol);
