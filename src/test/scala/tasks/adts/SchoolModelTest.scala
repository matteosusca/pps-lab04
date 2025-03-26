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

  @Test def testCourses(): Unit =
    val school = schoolModule.emptySchool
    assertEquals(Nil(), school.courses)