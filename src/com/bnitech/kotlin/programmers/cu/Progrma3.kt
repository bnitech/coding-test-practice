package com.bnitech.kotlin.programmers.cu

fun cu_program3(grades: Array<String>): Array<String> {
    val scores = mapOf(
        "A+" to 1,
        "A0" to 2,
        "A-" to 3,
        "B+" to 4,
        "B0" to 5,
        "B-" to 6,
        "C+" to 7,
        "C0" to 8,
        "C-" to 9,
        "D+" to 10,
        "D0" to 11,
        "D-" to 12,
        "F" to 13,
    )

    val subjects = mutableMapOf<String, String>()
    for (i in grades.indices) {
        val temp = grades[i].split(' ')
        val subject = temp[0]
        val grade = temp[1]
        val score = scores[grade]!!

        val value = subjects[subject]
        if (value == null) {
            subjects[subject] = grade
            continue
        }

        if (scores[value]!! > score) {
            subjects.remove(subject)
            subjects[subject] = grade
        }
    }

    val result = subjects.toList().sortedWith { a, b ->
        val aa = scores[a.second]!!
        val bb = scores[b.second]!!

        if (aa.compareTo(bb) == 0) 1 else aa.compareTo(bb)
    }.toMap()

    val answer = ArrayList<String>()
    for (entry in result.entries) {
        answer.add("${entry.key} ${entry.value}")
    }

    return answer.toTypedArray()
}