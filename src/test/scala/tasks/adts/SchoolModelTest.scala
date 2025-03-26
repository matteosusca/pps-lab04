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

  @Test def testCoursesEmpty(): Unit =
    assertEquals(Nil(), emptySchool.courses)

  @Test def testTeachersEmpty(): Unit =
    assertEquals(Nil(), emptySchool.teachers)

  @Test def testSetTeacherToCourse(): Unit =
    val school = emptySchool
      .setTeacherToCourse(teacher("John"), course("Math"))
      .setTeacherToCourse(teacher("John"), course("Italian"))
      .setTeacherToCourse(teacher("Alice"), course("Italian"))
    assertEquals(Cons("Math", Cons("Italian", Nil())), school.courses)
    assertEquals(Cons("John", Cons("Alice", Nil())), school.teachers)
