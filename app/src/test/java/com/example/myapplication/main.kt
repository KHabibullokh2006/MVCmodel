package com.example.myapplication


import java.util.Scanner

fun main() {
    var controller = Controller()
    controller.onClick()
}

class Controller() {
    val model = Model()
    val view = View()
    val init = Scanner(System.`in`)

    fun onClick() {
        view.message("Menu:\n 1. User qo'shish\n 2. Kurslar ro'yxati\n 3. Userlar ro'yxati\n 4. Kurs qo'shish\n 5. Kursdagi userlar\n 6. Kursga qo'shilish\n 7. Chiqish")
        var id = init.nextInt()

        when (id) {
            1 -> {
                addUser()
            }

            2 -> {
                courseList()
            }

            3 -> {
                usersList()
            }

            4 -> {
                addCourse()
            }

            5 -> {
                courseUsers()
            }

            6 -> {
                view.message("Siz tizimdan chiqdingiz!")
            }

            else -> {
                view.message("Bunday buyruq mavjud emas")
                onClick()
            }
        }
    }

    private fun courseUsers() {
        onClick()
    }

    private fun addCourse() {
        view.message("Kurs nomini kiriting: ")
        var coursename = init.nextLine()
        var courseid = 0

        if (coursename != "") {
            model.addCourse(Course(coursename, courseid, null))
            view.message("Siz muvaffaqiyatli kurs qo'shdingiz. Kurs raqami $courseid")
            courseid += 1
            onClick()
        }

    }

    private fun usersList() {
        model.showUsers()
        onClick()
    }

    private fun courseList() {
        model.showCourses()
        onClick()
    }

    private fun addUser() {
        view.message("Ismingizni kiriting: ")
        var name = init.nextLine()

        view.message("Yoshingizni kiriting:")
        var age = init.nextInt()
        var id = 0

        if (name != "" && age > 0) {
            model.addUser(User(id, name, age))
            view.message("Siz muvaffaqiyatli ro'yxatdan o'tdingiz. Sizning raqamingiz $id")
            id += 1
            onClick()
        }
    }


}

class View() {
    fun message(text: String) {
        println(text)
    }
}

class Model() {
    var users = mutableListOf<User>()
    var courses = mutableListOf<Course>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun showUsers() {
        if (users.size > 0) {
            println("Userlar ro'yxati: ")
            for (i in 0 until users.size) {
                println(users[i].name)
            }
        } else {
            println("Userlar mavjud emas")
        }
    }

    fun showCourses() {
        if (courses.size > 0) {
            println("Kurslar ro'yxati: ")
            for (i in 0 until courses.size) {
                println(courses[i].coursename)
            }
        } else {
            println("Kurslar mavjud emas")
        }
    }

    fun addCourse(course: Course) {
        courses.add(course)
    }

    fun showCourseUsers() {

    }
}

data class User(var id: Int, var name: String, var age: Int)
data class Course(var coursename: String, var courseid: Int, var students: MutableList<User>?)