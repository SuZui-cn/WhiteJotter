<!--<template>
  <el-card>
    用户名:<input
      type="text"
      v-model="loginForm.username"
      placeholder="请输入用户名"
    />
    <br /><br />
    密码：
    <input
      type="password"
      v-model="loginForm.password"
      placeholder="请输入密码"
    />
    <br /><br />
    <button v-on:click="login">登录</button>
  </el-card>
</template>
-->
<template>

  <body id="poster">
    <el-form
      class="login-container"
      label-position="left"
      label-width="0px"
    >
      <h3 class="login_title">系统登录</h3>
      <el-form-item>
        <el-input
          type="text"
          v-model="loginForm.username"
          auto-complete="off"
          placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%; background: #505458; border: none"
          v-on:click="login"
        >登录</el-button>
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: 'admin',
        password: '123456',
      },
      responseResult: [],
    }
  },
  methods: {
    login () {
      var _this = this
      if (this.loginForm.username === "" || this.loginForm.password === '') {
        this.$message.error("用户名或密码不能为空")
        return
      }
      if (this.loginForm.username.length < 2 || this.loginForm.username.length > 8) {
        this.$message.error("用户名应该在二到八位")
        return
      }
      if (this.loginForm.password.length < 3 || this.loginForm.password.length > 20) {
        console.log(this.loginForm.password.length)
        this.$message.error("密码应该在六到二十位")
        return
      }
      this.$axios
        .post('/login', {
          username: this.loginForm.username,
          password: this.loginForm.password,
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            _this.$store.commit('login', _this.loginForm)
            var path = this.$route.query.redirect
            this.$router.replace({ path: path === '/' || path === undefined ? '/library' : path })
          } else {
            this.$message.error("用户名或密码错误")
          }
        })
        .catch((failResponse) => { })
    }
  }
}
</script>
<style>
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
#poster {
  background: url("../assets/20190414165045567.jpg") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
</style>