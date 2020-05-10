function solution(reqs) {
  var map = new Map();
  var answer = [];
  for (var i = 0; i < reqs.length; i++) {
    sol = reqs[i].split(" ");

    if (sol[0] == "DEPOSIT") {
      if (map.get(sol[1]) == null) {
        answer.push("404");
      } else {
        var calc = map.get(sol[1]) + sol[2];
        map.set(sol[1], calc);
        answer.push("200");
      }
    } else if (sol[0] == "CREATE") {
      if (map.get(sol[1]) == null) {
        map.set(sol[1], sol[2]);
        answer.push("200");
      } else {
        answer.push("403");
      }
    } else {
      if (map.get(sol[1] == null)) {
        answer.push("404");
      } else {
        if (map.get(sol[1]) < sol[2]) {
          answer.push("403");
        } else {
          var cal = map.get(sol[1]) - sol[2];
          map.set(sol[1], cal);
          answer.push("200");
        }
      }
    }
  }
  console.log(answer);
  return answer;
}

var sol = ["CREATE 3a 10000", "CREATE 3a 20000", "CREATE 2bw 30000"];

solution(sol);
