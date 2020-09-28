import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
//Bootstrap
import { Container, Button } from 'react-bootstrap';
//CSS
import '../../css/Profile.css';
//Auth hook
import { useSelector, useDispatch } from 'react-redux';
import { placeholder, generateMediaUrl, coverPlaceholder } from '../../utilities';
import { fetchUserPosts, clearPosts } from '../../store/slices/posts';
import { useInfiniteScroll } from '../../hooks/useInfiniteScroll.js';
import PostsPage from './PostsPage';
import { useRouteMatch } from 'react-router-dom';
import { fetchUserByUsername, followUserById, unfollowUserById } from '../../store/slices/users';
import styled from 'styled-components';

const YourPostsLogo = styled.span`
color: #000;
font-family: 'Lobster', cursive;
letter-spacing: 0.2rem;
font-size: 7rem;
`;

function Profile() {
    const routeMatcher = useRouteMatch("/users/:username");
    const user = useSelector(state => state.user.user);
    const authUser = useSelector(state => state.auth.user);
    const dispatch = useDispatch();
    const posts = useSelector(state => state.posts.posts);
    const isLoading = useSelector(state => state.posts.isLoading);
    const cursor = useSelector(state => state.posts.cursor);
    const username = routeMatcher.params.username === 'me' ? authUser.username : routeMatcher.params.username;
    const boundaryRef = useInfiniteScroll({
        onLoadMore: () => dispatch(fetchUserPosts(user.id)),
        isLoading,
        hasMore: !posts.length || cursor,
    });


    React.useEffect(() => {
        dispatch(clearPosts());
        dispatch(fetchUserByUsername({ username }));
        dispatch(fetchUserPosts({ userId: user?.id }));
    }, [username, dispatch]);


    if (!user) {
        return (<div>NO USER FOUND</div>);
    }
    else {
        return (
            <>
                <Container fluid="xl">
                    <img className="rela-block cover" src={coverPlaceholder} alt="Profile Cover" />
                    <div className="rela-block profile-card">
                        <img src={user.avatarId ? generateMediaUrl(user.avatarId) : placeholder} className="profile-pic" alt="Profile Avatar" />
                        <div className="rela-block profile-name-container">
                            <div className="rela-block real-name" >{user.name}</div>
                            <div className="rela-block user-name" >({user.username})</div>
                            <div className="rela-block user-desc" >{user.caption}</div>
                        </div>
                        <div className="rela-block profile-card-stats">
                            <div className="floated profile-stat followers" >{user.followersCount}<br /> Followers</div>
                            {((user.id !== authUser.id) && !user.following) &&
                                <div className="floated profile-stat liked" ><Button onClick={() => dispatch(followUserById(user.id))} className="btn-dark">Follow</Button></div>
                            }
                            {((user.id !== authUser.id) && user.following) &&
                                <div className="floated profile-stat liked" ><Button onClick={() => dispatch(unfollowUserById(user.id))} className="btn-light">Unfollow</Button></div>
                            }
                            {user.id === authUser.id &&
                                <div className="floated profile-stat" ></div>
                            }
                            <div className="floated profile-stat following">{user.followingCount}<br /> Following</div>
                        </div>
                    </div>
                    {posts.length > 0 &&
                        <div className="d-flex justify-content-center">
                            <YourPostsLogo>Your posts</YourPostsLogo>
                        </div>}
                    <PostsPage posts={posts}></PostsPage>
                    <div ref={boundaryRef}></div>
                </Container>
            </>
        );
    }

}

export default Profile;