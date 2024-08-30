<template>
    <Dialog header="Dialog" v-model:visible="display" :breakpoints="{ '960px': '75vw' }" :style="{ width: '30vw' }" :modal="true">
        <p class="leading-normal m-0">회원가입</p>
        <template #footer>
            <Button label="Save" @click="close" />
        </template>
    </Dialog>
</template>

<script setup></script>

<style lang="scss" scoped></style>
