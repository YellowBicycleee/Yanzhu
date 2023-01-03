<template>
  <div class="wrapper">
    <div
      class="query-box"
    >
      <div class="search-box">
        <el-form :inline="true" label-width="80px">
          <el-form-item label="学校">
            <el-input v-model="query.cname" placeholder="请输入学校" style="margin-right: 20px; width: 177px" clearable />
          </el-form-item>
          <el-form-item label="学院">
            <el-input v-model="query.sname" placeholder="请输入学院" style="margin-right: 20px; width: 177px" clearable />
          </el-form-item>
          <el-form-item label="专业名称">
            <el-input v-model="query.dname" placeholder="请输入专业名称" style="margin-right: 20px; width: 177px" clearable />
          </el-form-item>
          <el-form-item label="年份">
            <el-date-picker
              v-model="query.year"
              type="year"
              value-format="yyyy"
              placeholder="选择年份"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="queryList">查询</el-button>
            <el-button @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <div class="table-box">
      <el-table
        ref="table"
        v-loading="loading"
        :data="list4Show"
        style="width: 100%;"
        border
        stripe
        height="100%"
      >
        <el-table-column
          type="index"
          align="center"
          label="序"
          width="55"
          fixed
        />
        <el-table-column
          prop="cname"
          label="学校"
          width="200"
          show-overflow-tooltip
        />
        <el-table-column
          prop="sname"
          label="学院名称"
          width="200"
          show-overflow-tooltip
        />
        <el-table-column
          prop="dname"
          label="专业名称"
          width="180"
          show-overflow-tooltip
        />
        <el-table-column
          prop="year"
          label="年份"
          width="120"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="total"
          label="总分"
          width="100"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="class1Grade"
          label="课程一"
          width="80"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="class2Grade"
          label="课程二"
          width="80"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="class3Grade"
          label="课程三"
          width="80"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="class4Grade"
          label="课程四"
          width="80"
          align="right"
          show-overflow-tooltip
        />
        <el-table-column
          prop="info"
          label="其他"
          show-overflow-tooltip
          min-width="180"
        >
          <template slot-scope="scope">
            <el-link :href="scope.row.info" target="_blank" type="primary">{{ scope.row.info }}</el-link>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <pagination v-show="total>0" :total="total" :page.sync="pageInfo.page" :limit.sync="pageInfo.size" />
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { getKaoYanList } from '@/api/table'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ]),
    list4Show() {
      const { page, size } = this.pageInfo

      return this.list.slice((page - 1) * size, page * size)
    }
  },
  components: {
    Pagination
  },
  data() {
    return {
      query: {
      },
      pageInfo: {
        page: 1,
        size: 20
      },
      loading: false,
      list: [],
      total: 0
    }
  },
  mounted() {
    this.queryList()
  },
  methods: {
    reset() {
      this.query = {}
      this.queryList()
    },
    queryList() {
      console.log(this.query, '---------')
      this.loading = true
      const { cname, sname, year } = this.query || {}
      console.log(cname, sname, year)
      getKaoYanList({ cname, sname, year }).then(res => {
        console.log(res)
        this.list = res
        this.total = res.length
        this.loading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.wrapper {
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  padding: 30px 20px;
  background-color: #f0f2f5;
  .query-box {
    margin: 20px 0;
    display: flex;
    justify-content: space-between;
    background: #fff;
    padding: 18px 16px 0;
    align-items: flex-start;
    .search-box {
      display: flex;
      flex: 1;
    }
    .selector {
      margin-left: 20px;
    }
  }
  .table-box {
    flex: 1;
    padding: 16px;
    background: #fff;
    overflow: hidden;
  }
}
</style>

