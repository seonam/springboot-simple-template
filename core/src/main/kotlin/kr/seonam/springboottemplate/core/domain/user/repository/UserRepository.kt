package kr.seonam.springboottemplate.core.domain.user.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.seonam.springboottemplate.core.domain.user.model.QUser
import kr.seonam.springboottemplate.core.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository :
    JpaRepository<User, Long>,
    UserCustomRepository

interface UserCustomRepository {
    fun findByUserId(id: Long): User?
}

class UserRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : UserCustomRepository {
    private val user = QUser.user

    override fun findByUserId(id: Long): User? =
        jpaQueryFactory
            .selectFrom(user)
            .where(
                user.id.eq(id),
                user.isDeleted.isFalse,
            ).fetchOne()
}
