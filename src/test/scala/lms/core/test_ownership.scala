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
        var x: Rep[Array[Array[Int]]] = NewArray[Array[Int]](10)
        val y = x // cannot see the node
        x(1) = NewArray[Int](5) // should have an error
        printf("%d\n", y(1))
        x.free

      }
    }
    check("test1", driver.code, "c")
  }

  test("test2") {
    val driver = new DslDriverC[Int, Unit] {
      @virtualize
      def snippet(arg: Rep[Int]) = {
        var x: Rep[Array[Array[Int]]] = NewArray[Array[Int]](10)
        val y = x.&(0)
        x(1) = NewArray[Int](5)
        printf("%d\n", y(1))
        x.free

      }
    }
    check("test2", driver.code, "c")
  }

  test("test3") {
    val driver = new DslDriverC[Int, Unit] {
      @virtualize
      def snippet(arg: Rep[Int]) = {
        var x: Rep[Array[Array[Int]]] = NewArray[Array[Int]](10)
        def f: Rep[Array[Int] => Int] =
          topFun((x: Rep[Array[Int]]) => {
            printf("%d\n", x(1))
            x(1)
          })

        f(x(0))
        printf("%d\n", x(0)(0))

      }
    }
    check("test3", driver.code, "c")
  }

}
