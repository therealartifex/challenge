import Foundation

func rangingXor(a: Int, b: Int) -> Int {
  if(a == 0){
    if(b % 4 == 0){
      return b
    }
    if(b % 4 == 1){
      return 1
    }
    if(b % 4 == 2){
      return b+1
    }
    if(b % 4 == 3){
      return 0
    }
    return 0
  }else{
    return rangingXor(a: 0, b: b) ^ rangingXor(a: 0, b: a-1)
  }
}

let t = Int(readLine()!)!
for i in 0..<t {
  let input = readLine()!.characters.split(separator: " ").map{ Int(String($0))! }
  let l = input[0]
  let h = input[1]
  let n = input[2]
  
  let d1 = input[3] - n
  let d2 = input[4] - n
  
  let x1 = min(d1 % l, d2 % l)
  let x2 = max(d1 % l, d2 % l)
  let y1 = min(d1 / l, d2 / l)
  let y2 = max(d1 / l, d2 / l)
  
  var val = 0
  for i in 0..<h {
    let offset = n + i*l
    var xor = 0
    xor ^= rangingXor(a: offset, b: offset + l - 1)
    if i >= y1 && i <= y2 {
      xor ^= rangingXor(a: offset + x1, b: offset + x2)
    }
    val ^= xor
  }
  /*
  for j in 0..<x1 {
    let offset = n + j
    var xor = 0
    if h % 4 == 1 {
      xor ^= (h-1) * l + offset
    }else if h % 4 == 2 {
      xor ^= l
    }else if h % 4 == 3 {
      xor ^= h * l + offset
    }
    
    xor = 0
    for i in 0..<h {
      xor ^= (n + i*l + j)
    }

    print("\(j): h is \(h), result is \(xor)")
    val ^= xor
  }
  for j in x2+1..<l {
    for i in 0..<h {
      val ^= (n + i*l + j)
    }
  }

  for i in 0..<y1 {
    let offset = n + i*l
    let xor = rangingXor(a: (offset + x1), b: (offset + x2))
    val ^= xor
  }
  for i in y2+1..<h {
    let offset = n + i*l
    val ^= rangingXor(a: (offset + x1), b: (offset + x2))
  }
*/
  print(val)
}
