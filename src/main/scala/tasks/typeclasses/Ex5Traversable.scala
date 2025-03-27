package u04lab
import u03.Sequences.*
import Sequence.*
import u03.Optionals.Optional
import u03.Optionals.Optional.*

/*  Exercise 5: 
 *  - Generalise by ad-hoc polymorphism logAll, such that:
 *  -- it can be called on Sequences but also on Optional, or others... 
 *  -- it does not necessarily call log, but any function with analogous type
 *  - Hint: introduce a type class Traversable[T[_]]], capturing the ability of calling a
 *    "consumer function" on all elements (with type A) of a datastructure T[A] 
 *    Note Traversable is a 2-kinded trait (similar to Filterable, or Monad)
 *  - Write givens for Traversable[Optional] and Traversable[Sequence]
 *  - Show you can use the generalisation of logAll to:
 *  -- log all elements of an Optional, or of a Traversable
 *  -- println(_) all elements of an Optional, or of a Traversable
 */

object Ex5Traversable:

  def log[A](a: A): Unit = println("The next element is: "+a)

  def logInLine[A](a: A): Unit = print(a.toString + ", ")

  trait Traversable[T[_]]:
    def traverse[A](seq: T[A], f: A => Unit): Unit
    extension [A](seq: T[A])
      def logAll(f: A => Unit = log): Unit = traverse(seq, f)


  given Traversable[Optional] with
    def traverse[A](opt: Optional[A], f: A => Unit): Unit = opt match
      case Just(a) => f(a)
      case _ => ()

  given Traversable[Sequence] with
    def traverse[A](seq: Sequence[A], f: A => Unit): Unit = seq match
      case Cons(h, t) => f(h); traverse(t, f)
      case _ => ()

  /* def logAll[A](seq: Sequence[A]): Unit = seq match
    case Cons(h, t) => log(h); logAll(t)
    case _ => () */

  // main
  @main def tryTraversable =
    val si = Cons(10, Cons(20, Cons(30, Nil())))
    si.logAll() // 10, 20, 30
    si.logAll(logInLine)
    println()

    val opt = Optional.Just(4)
    opt.logAll()
