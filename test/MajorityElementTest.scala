import org.scalatest.FlatSpec

class MajorityElementTest extends FlatSpec {

  behavior of "MajorityElement"

  it should "check if there is a majority number for a case" in {
    assert(MajorityElement.getMajorityElement(Array(2,3,9,2,2), 0, 5) == 2)
  }

  it should "check if there is a majority number for b case" in {
    assert(MajorityElement.getMajorityElement(Array(1,2,3,4), 0, 4) == -1)
  }

  it should "check if there is a majority number for c case" in {
    assert(MajorityElement.getMajorityElement(Array(1,2,3,1), 0, 4) == -1)
  }

  it should "check if there is a majority number for d case" in {
    assert(MajorityElement.getMajorityElement(Array(0,1), 0, 2) == -1)
  }

}
