package co.com.scalatraining.collections

import org.scalatest.FunSuite

import scala.collection.immutable.Stack



class StackSuite extends FunSuite {

  test("Se puede crear una Pila"){
    val pila = Stack(1,2,3,4)
    val pila1 = new Stack()

    assert(pila == Stack(1,2,3,4))
    assert(pila1 == Stack() )
  }

  test("Una pila se debe poder recorrer imperativamente"){
    val pila = Stack(1,2,3,4)

    var mul = 1
    pila.foreach((x) =>
      mul *= x )

    assert(mul == 24)
  }

  test("Se puede retirar el ultimo elemento apilado"){
    val pila = Stack(1,2,3,4)
    val ultimo = pila.pop

    assert(ultimo == Stack(2,3,4))
  }


  test("Se puede apilar varios elementos en la pila"){
    val pila = Stack(3,4)
    val pila2 = pila.push(2,1)

    assert(pila2 == Stack(1,2,3,4))
  }

  test("Se debe poder reversar una pila"){
    val pila = Stack(1,2,3,4)
    val pila2 = pila.reverse

    assert(pila2 == Stack(4,3,2,1))
  }

  test("Se debe poder comparar dos pilas iguales"){
    val pila = Stack(1,2,3,4)
    val pila2 = Stack(1,2,3,4)
    val bool = pila.sameElements(pila2)
    val pila3 = pila.tail

    assert(bool == true)
    assert(pila3 == pila.tail)
  }

}
