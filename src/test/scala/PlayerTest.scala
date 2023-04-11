package cl.uchile.dcc
package gwent

import munit.FunSuite
class PlayerTest extends FunSuite {
  var player: Player = _
  var computerAI: Player= _

  override def beforeEach(context: BeforeEach): Unit = {
    // por ahora existen menos de 25 cartas porque estamos probando nomas
    player = new Player(name = "Angelo", section= "1", gems=10, deck=List("a","b","c"), hand=List("aa","bb","cc") )
    computerAI = new Player(name = "ChatGPT",  section= "2", gems=10, deck=List("x","y","z"), hand=List("xx","yy","zz"))
  }
  test ("a player must have a name") {
    assertEquals(player.name, "Angelo")
    assertEquals(computerAI.name, "ChatGPT")
  }

  test("a player must have a section of the board") {
    assertEquals(player.board, "1")
    assertEquals(computerAI.board, "2")
  }

  test("a player must have a number of gems") {
    assertEquals(player.gems, 10)
    assertEquals(computerAI.gems, 10)
  }

  test("a player must have a deck of cards") {
    assertEquals(player.deck, List("a","b","c"))
    assertEquals(computerAI.deck, List("x","y","z"))
  }

  test("a player must have cards in their hand") {
    assertEquals(player.hand, List("aa","bb","cc"))
    assertEquals(computerAI.hand, List("xx","yy","zz"))
  }

  test("a player must be able to play a card from their hand") {
    assert(player.playCard(index=0))
    player.playCard(index=0)
    assertEquals(player.hand, List("bb","cc"))
    assertEquals(computerAI.playCard(index = 4), false)
    computerAI.playCard(index = 4)
    assertEquals(computerAI.hand, List("xx", "yy","zz"))
  }

  test("a player must be able to draw a card from their deck") {
    assert(player.drawCard(index = 0))
    player.drawCard(index = 0)
    assertEquals(player.hand, List("bb", "cc","a"))
    assertEquals(player.deck, List("b", "c"))
    assertEquals(computerAI.drawCard(index = 4), false)
    computerAI.playCard(index = 4)
    assertEquals(computerAI.hand, List("xx", "yy", "zz"))
    assertEquals(computerAI.deck, List("x", "y", "z"))
  }
}
