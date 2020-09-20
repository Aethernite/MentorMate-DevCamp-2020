import faker from 'faker';

export const generateUser = () => {
    return {
        avatar: faker.image.avatar(),
        name: faker.name.findName(),
        description: faker.lorem.paragraph(1),
        key: faker.random.uuid(),
        cover: faker.image.city(),
        followers: faker.random.number(500),
        following: faker.random.number(500),
        likes: faker.random.number(500)
    }
}

export const generatePosts = (num) => {
    let posts = [];
    for (let i = 0; i < num; i++) {
        const post = {
            authorAvatar: faker.image.avatar(),
            author: faker.name.findName(),
            location: faker.address.city(),
            timestamp: new Date(Date.now()).toUTCString(),
            contentImage: `${faker.image.nature()}?random=${faker.random.number()}`,
            comments: faker.random.number(500),
            likes: faker.random.number(500),
            shares: faker.random.number(500),
            usersLiked: [generateUser(), generateUser(), generateUser(), generateUser()]
        }
        posts.push(post);
    }
    return posts;
};


