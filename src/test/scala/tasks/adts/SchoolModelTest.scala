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

  @Test def testTeachersEmpty(): Unit =
    assertEquals(Nil(), emptySchool.teachers)

  @Test def testSetTeacherToCourse(): Unit =
    val newSchool = emptySchool.setTeacherToCourse(teacher("John"), course("Math"))
    assertEquals(Cons(("John", "Math"), Nil()), newSchool)
    
  @Test def testHasTeacher(): Unit =
    assertTrue(standardSchool.hasTeacher("John"))
    assertFalse(standardSchool.hasTeacher("Bob"))
