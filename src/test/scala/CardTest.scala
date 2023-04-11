package cl.uchile.dcc
package gwent

import munit.FunSuite

class CardTest extends FunSuite {
  val card1: Card = _
  val card2: Card = _
  // no entendi que implementar aca :c
  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new Card(name="generic card 1",clasifaction="one")
    card2 = new Card(name="generic card 2",clasifaction="two")
  }

}
