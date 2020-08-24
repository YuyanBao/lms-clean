package lms
package core

import stub._
import macros.SourceContext

class OwnershipTest extends TutorialFunSuite {
  val under = "backend/"

  test("test1") {
    val driver = new DslDriverC[Int, Unit] {
      @virtualize
      def snippet(arg: Rep[Int]) = {
        var x: Rep[Array[Int]] = NewArray[Int](10)
        val y = x
        val z = x(1)
        // x(1) = 2
        printf("%d\n", y(1))
        printf("%d\n", z)
        printf("%d\n", x(1))
        x.free

      }
    }
    check("test1", driver.code, "c")
  }

}
