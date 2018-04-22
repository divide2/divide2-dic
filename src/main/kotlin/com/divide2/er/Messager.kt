package com.divide2.er

/**
 * Created by bvvy on 2018/2/5.
 * com.divide2
 */
class Messager(val code: String) {

    companion object {

        fun of(code: String): Messager {
            return Messager(code)
        }

        fun of(returnCoder: ReturnCoder): Messager {
            return Messager(returnCoder.msg)
        }
    }
}
