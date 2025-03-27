package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*



class SchoolModelTest:
  import schoolModule.*
  import u03.Sequences.*
  import u03.extensionmethods.Sequences.Sequence.*

  val schoolModule: SchoolModule = BasicSchoolModule
  val emptySchool: School = schoolModule.emptySchool
  val standardSchool: School = emptySchool
    .setTeacherToCourse(teacher("John"), course("Math"))
    .setTeacherToCourse(teacher("John"), course("Italian"))
    .setTeacherToCourse(teacher("Alice"), course("Italian"))

  @Test def testCoursesEmpty(): Unit =
    assertEquals(Nil(), emptySchool.courses)

  @Test def testCoursesStandard(): Unit =
    assertEquals(Cons("Math", Cons("Italian", Nil())), standardSchool.courses)

  @Test def testTeachersEmpty(): Unit =
    assertEquals(Nil(), emptySchool.teachers)

  @Test def testTeachersStandard(): Unit =
    assertEquals(Cons("John", Cons("Alice", Nil())), standardSchool.teachers)

  @Test def testSetTeacherToCourse(): Unit =
    val newSchool = emptySchool.setTeacherToCourse(teacher("John"), course("Math"))
    assertEquals(Cons(("John", "Math"), Nil()), newSchool)
    val newSchool2 = newSchool.setTeacherToCourse(teacher("Alice"), course("Math"))
    assertEquals(Cons(("John", "Math"), Cons(("Alice", "Math"), Nil())), newSchool2)
    
  @Test def testHasTeacher(): Unit =
    assertTrue(standardSchool.hasTeacher("John"))
    assertFalse(standardSchool.hasTeacher("Bob"))
    
  @Test def testHasCourse(): Unit =
    assertTrue(standardSchool.hasCourse("Math"))
    assertFalse(standardSchool.hasCourse("History"))
