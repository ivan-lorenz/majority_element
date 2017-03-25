import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}

object MajorityElementCheck extends Properties("MajorityElement"){

  val genNumbers: Gen[Int] = Gen.choose(1, 1000)
  val listOfNumbers: Gen[Array[Int]] =
    for {
      size <- Gen.choose(1,100)
      elems <- Gen.containerOfN[Array, Int](size, genNumbers)
    } yield elems

  property("compute majority element in") =
    forAll(listOfNumbers){list  =>
      val maxed = list.toList
        .foldLeft(Map.empty[Int, Int]){(acc, i) =>
          val count: Int = acc.getOrElse(i,0)
          acc + (i -> (count + 1))
        }.maxBy(_._2)
      val expectedResult = if (maxed._2 > (list.size / 2)) maxed._1 else -1
      val result = MajorityElement.getMajorityElement(list, 0 , list.length)
      val assertion =  result == expectedResult
      if (!assertion)
        System.out.println(s"ERROR for list : ${list.mkString(",")} with expected result = ${expectedResult} and actual result = $result")
      assertion
    }

}
